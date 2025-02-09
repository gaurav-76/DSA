
public class InorderSuccessorORCeil {

    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public TreeNode root;
   TreeNode[] successor = new TreeNode[1];
   TreeNode[] ceil = new TreeNode[1];

    public void createBST(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        fourth.left = second;
        second.left = first;
        second.right = third;

        fourth.right = sixth;
        sixth.left = fifth;
        sixth.right = eight;
        
        eight.left = seventh;

        root = fourth;

        //          4
        //        /   \
        //       2     6
        //      / \   / \
        //     1   3 5   8
        //               /
        //              7
    }

    //Recursive
    public void inorderSuccessor(TreeNode root, int key, TreeNode[] successor){
        if(root == null){
            return;
        }

        if(key >= root.data){
            inorderSuccessor(root.right, key, successor);
        }
        else{
            successor[0] = root;
            inorderSuccessor(root.left, key, successor);
        }
    }

    //Iterative
    public void findCeil(TreeNode root, int key, TreeNode[] ceil){
        
        while(root != null){
            if(root.data == key){
                ceil[0] = root;
                return;
            }

            if(key > root.data){
                root = root.right;
            }
            else{
                ceil[0] = root;
                root = root.left;
            }
        }
    }
    public static void main(String[] args) {
        
        InorderSuccessorORCeil bst = new InorderSuccessorORCeil();
        bst.createBST();

        //Inorder Successor : The number just greater than the target is the successor
        int key = 5;
        bst.inorderSuccessor(bst.root, key, bst.successor);

        if(bst.successor[0] != null){
            System.out.print("Inorder Successor for key " + key + " : " + bst.successor[0].data);
        }
        else{
            System.out.println("No Successor : -1");
        }
        
        //Ceil In BST : Ceil(X) is a number that is either equal to X or is immediately greater than X.
        //              If Ceil could not be found, return -1.
        
        System.out.println();
        bst.findCeil(bst.root, key, bst.ceil);
        if(bst.ceil[0] != null){
            System.out.println("Ceil of key " + key + " : " + bst.ceil[0].data);
        }
        else{
            System.out.println("Ceil Not present : -1");
        }
    }
}
