import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    static TreeNode root;
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

    //level order traversal
    public void levelOrder(TreeNode root){
        if(root == null) return;

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        while(!que.isEmpty()){
            TreeNode currNode = que.poll();
            System.out.print(currNode.data + " ");

            if(currNode.left != null) que.offer(currNode.left);
            if(currNode.right != null) que.offer(currNode.right);
        }
    }
    public static void main(String[] args) {
        
        LevelOrderTraversal lt = new LevelOrderTraversal();
        lt.createBinaryTree();

        System.out.print("LevelOrder Traversal : ");
        lt.levelOrder(root);  //o/p : 1 2 3 4 5 6
    }
}
