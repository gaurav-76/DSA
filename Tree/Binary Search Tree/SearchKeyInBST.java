public class SearchKeyInBST {

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

    //Recursive Code
    // public boolean search(TreeNode root, int key){
    //     if(root == null){
    //         return false;
    //     }

    //     if(key == root.data){
    //         return true;
    //     }

    //     if(key < root.data){
    //         return search(root.left, key);
    //     }

    //     return search(root.right, key);
    // }

    //Iterative Code
    public boolean search(TreeNode root, int key){
        if(root == null){
            return false;
        }

        while(root != null && root.data != key){
            // if(key < root.data){
            //     root = root.left;
            // }
            // else{
            //     root = root.right;
            // }
            root = key < root.data ? root.left : root.right;
        }

        return root != null;
    }
    public static void main(String[] args) {
        
        SearchKeyInBST bst = new SearchKeyInBST();
        bst.createBST();

        int key = 6;
        
        // System.out.println("Recursive Function");
        
        // if(bst.search(bst.root, key) == true){
        //     System.out.println("Key Found !!!");
        // }
        // else{
        //     System.out.println("Key not Found !!!");
        // }

        System.out.println("Iterative Function");
        
        if(bst.search(bst.root, key) == true){
            System.out.println("Key Found !!!");
        }
        else{
            System.out.println("Key not Found !!!");
        }
    }
}
