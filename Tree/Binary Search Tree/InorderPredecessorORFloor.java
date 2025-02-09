public class InorderPredecessorORFloor {

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
    TreeNode[] predecessor = new TreeNode[1];
    TreeNode[] floor = new TreeNode[1];

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

    //Iterative Code
    public void inorderPredecessor(TreeNode root, int key, TreeNode[] predecessor){
        
        while(root != null){
            if(key <= root.data){
                root = root.left;
            }
            else{
                predecessor[0] = root;
                root = root.right;
            }
        }
    }

    public void findFloor(TreeNode root, int key, TreeNode[] floor){
        if(root == null){
            return;
        }

        if(root.data == key){
            floor[0] = root;
            return;
        }

        if(key < root.data){
            findFloor(root.left, key, floor);
        }
        else{
            floor[0] = root;
            findFloor(root.right, key, floor);
        }
    }
    public static void main(String[] args) {
        
        InorderPredecessorORFloor bst = new InorderPredecessorORFloor();
        bst.createBST();

        //Inorder Predecessor : The number just smaller than the target is the Predecessor
        int key = 5;
        bst.inorderPredecessor(bst.root, key, bst.predecessor);

        if(bst.predecessor[0] != null){
            System.out.print("Inorder Predecessor for key " + key + " : " + bst.predecessor[0].data);
        }
        else{
            System.out.println("No Predecessor : -1");
        }
        
        //Floor In BST : your task is to find the greatest value node of the BST which is 
        //               smaller than or equal to x
        
        System.out.println();
        bst.findFloor(bst.root, key, bst.floor);
        if(bst.floor[0] != null){
            System.out.println("Floor of key " + key + " : " + bst.floor[0].data);
        }
        else{
            System.out.println("Floor Not present : -1");
        }
    }
}
