
/*
    Diameter of Binary Tree (LC : 543)
    The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
    This path may or may not pass through the root.

    The length of a path between two nodes is represented by the number of edges between them.
*/


public class DiameterOfBT {

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

    // //helper function to calculate height
    // public int height(TreeNode root){
    //     if(root == null) return 0;

    //     int left = height(root.left);
    //     int right = height(root.right);

    //     return 1 + Math.max(left, right);
    // }

    // //Intuition
    // /*
    //     For every node we will calculate lh + rh , and will keep track of maximum diamater in variable maxi 
    // */

    // public int diameterOfBinaryTree(TreeNode root){

    //     if(root == null){
    //         return 0;
    //     }

    //     // Get the height of left and right subtrees
    //     int leftHeight = height(root.left);
    //     int rightHeight = height(root.right);

    //     // Diameter passing through the current node
    //     int diamaterThroughNode = leftHeight + rightHeight;        

    //      // Diameter in the left and right subtrees
    //     int leftDiameter = diameterOfBinaryTree(root.left);
    //     int rightDiameter = diameterOfBinaryTree(root.right);
        
    //     // Return the maximum diameter
    //     return Math.max(diamaterThroughNode, Math.max(leftDiameter, rightDiameter));
    // }

    //Optimal Appraoch
    public int diameter = 0;
    public int height(TreeNode root){
        if(root == null) return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return 1 +Math.max(leftHeight, rightHeight);
    }
    public int diameterOfBinaryTree(TreeNode root){
        if(root == null) return 0;

        height(root);
        return diameter;
    }

    public static void main(String[] args) {
        
        DiameterOfBT bt = new DiameterOfBT();
        bt.createBinaryTree();

        //Brute force
        //System.out.println("Diameter of Binary Tree : " + bt.diameterOfBinaryTree(root));

        //Optimal Approach
        System.out.println("Diameter of Binary Tree : " + bt.diameterOfBinaryTree(root));
    }
}
