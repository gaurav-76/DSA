import java.util.LinkedList;
import java.util.Queue;

class BinaryTree{

    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    TreeNode root;
    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);

        /*
                  1
                /   \
               2     3
              /  \    \
             4    5    6  
        */

        root = first;
        first.left = second;
        first.right = third;

        second.left = fourth;
        second.right = fifth;

        third.right = sixth;
    }

    public void prinLevelOrder(){
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while (!que.isEmpty()) {
            int size = que.size();
            System.out.print("Level 1 : ");
            for(int i = 0; i < size; ++i){
                TreeNode curr = que.poll();
    
                System.out.print(curr.data + " ");

                if(curr.left != null) que.offer(curr.left);
                if(curr.right != null) que.offer(curr.right);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        bt.prinLevelOrder();
    }
}