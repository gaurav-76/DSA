import java.util.LinkedList;
import java.util.Queue;

public class InorderPreorderBT {

    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    //level order traversal
    public void printLevelOrder(TreeNode root){
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; ++i){
                TreeNode curr = que.poll();
    
                System.out.print(curr.data + " ");

                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
            }
            System.out.println();
        }
    }

    public TreeNode solve(int[] idx, int[] preorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }

        int rootVal = preorder[idx[0]++];
        TreeNode root = new TreeNode(rootVal);

        int i;
        //now find rootVal position in inorder
        for(i = start; i <= end; ++i){
            if(rootVal == inorder[i]){
                break;
            }
        }

        root.left = solve(idx, preorder, inorder, start, i-1);
        root.right = solve(idx, preorder, inorder, i+1, end);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder){
        
        int n = preorder.length;
        if(n == 0) return null;

        //here in java for variable pass by reference is not supported
        //int idx = 0;
        int[] idx = {0}; //we need to use this because array is always pass by reference
        //{idx will use to get root, preorder, inorder, start, end}
        return solve(idx, preorder, inorder, 0, n-1);
    }

    public static void main(String[] args) {
        
        int[] preorder = {1, 2, 4, 6, 5, 3, 7, 8, 9, 10};
        int[] inorder  = {4, 2, 5, 6, 1, 3, 8, 9, 7, 10};

        InorderPreorderBT bt = new InorderPreorderBT();
        TreeNode root = bt.buildTree(preorder, inorder);

        bt.printLevelOrder(root);      
        // 1 
        // 2 3 
        // 4 6 7 
        // 5 8 10 
        // 9  
    }
}
