import java.util.LinkedList;
import java.util.Queue;

public class InorderPostorderBT{

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

    //Approach 1
    public TreeNode solve(int[] idx, int[] postorder, int[] inorder, int start, int end){
        if(start > end){
            return null;
        }

        int rootVal = postorder[idx[0]--];
        TreeNode root = new TreeNode(rootVal);

        int i;
        //now find rootVal position in inorder
        for(i = start; i <= end; ++i){
            if(rootVal == inorder[i]){
                break;
            }
        }

        //first we go right side
        root.right = solve(idx, postorder, inorder, i+1, end);
        //then left side
        root.left = solve(idx, postorder, inorder, start, i-1);
        

        return root;
    }

    //Approach 2
    public TreeNode solve1(int[] postorder, int[] inorder, int inStart, int inEnd, int postStart, int postEnd){

        if(inStart > inEnd){
            return null;
        }

        //last element of postorder will be root
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int i;
        for(i = inStart; i <= inEnd; ++i){
            if(rootVal == inorder[i]){
                break;
            }
        }

        //this size is caculated so that we can traverse only in those subarray
        int leftSize = i - inStart; //left side of postorder for left side inorder
        int rightSize = inEnd - i; //rigth side of postorder for right side inorder

        root.left  = solve1(postorder, inorder, inStart, i-1, postStart, postStart + leftSize -1);
        root.right = solve1(postorder, inorder, i+1, inEnd, postEnd - rightSize, postEnd-1);

        return root;
    }
    public TreeNode buildTree(int[] postorder, int[] inorder){
        
        int n = postorder.length;
        if(n == 0) return null;

        //here in java for variable pass by reference is not supported
        //int idx = n-1;
        //we will start from end
        int[] idx = {n-1}; //we need to use this because array is always pass by reference
        //{idx will use to get root, preorder, inorder, start, end}

        //Approach 1
        //return solve(idx, postorder, inorder, 0, n-1);

        //Approach 2
        int inStart = 0;
        int inEnd = n-1;

        int postStart = 0;
        int postEnd = n-1;
        return solve1(postorder, inorder, inStart, inEnd, postStart, postEnd);
    }

    public static void main(String[] args) {
        
        int[] postorder = {4, 5, 6, 2, 9, 8, 10, 7, 3, 1};
        int[] inorder  = {4, 2, 5, 6, 1, 3, 8, 9, 7, 10};

        InorderPostorderBT bt = new InorderPostorderBT();
        TreeNode root = bt.buildTree(postorder, inorder);

        bt.printLevelOrder(root);      
        // 1 
        // 2 3 
        // 4 6 7 
        // 5 8 10 
        // 9  
    }
}

