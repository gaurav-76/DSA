public class HeightOfBT {

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
        TreeNode seventh = new TreeNode(7);
    
    /*
                1
              /   \
             2     3
            /  \    \
           4    5    6  
          /
         7
    */

        root = first;
        first.left = second;
        first.right = third;
    
        second.left = fourth;
        second.right = fifth;
    
        third.right = sixth;

        fourth.left = seventh;
    }

    //Height of Binary Tree
    public int height(TreeNode root){
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public static void main(String[] args) {
        
        HeightOfBT bt = new HeightOfBT();
        bt.createBinaryTree();
        
        System.out.println("Height of Binary Tree : " + bt.height(root));
    }
}
