public class DeleteNodeInBST {

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

    //Intuition
    //First we search key in given bst
    //If we not found key then we simply return

    //If we found key, then we try to get the parent node as well
    //Now we have several cases for key node
    //Case 1 : T found in the BST. It has no children which means it is a leaf node. So, we can delete it just by updating T's parent pointer to null and then deleting T

    //Case 2 : T found in BST and only has the right child/subtreeCant directly delete T as it has its right child that must remain in the BST we update child pointer of parent of T to the right child of T

    //Case 3 : T found in BST and only has the left child/subtree. This is similar to previous case Cant directly delete T bcoz we need to take care of its left child We update child pointer of parent of T to the left child of T

    //Case 4 : T found in BST and has both left and right child/subtree In this case, to maintain BST property, we have two choices - Replace T by largest node in left subtree Replace T by smallest node in right subtree

    TreeNode parent = null;
    TreeNode node = null;

    public boolean search(TreeNode root, int key){
        if(root == null) return false;

        while(root != null && root.data != key){
            parent = root;
            root = key < root.data ? root.left : root.right;
        }

        node = root;
        return root != null;
    }
    public TreeNode deleteNode(TreeNode root, int key){
        if(root == null){
            return null;
        }

        if(!search(root, key)){
            return root;
        }

        //If node is leaf node
        //If node's left is null OR If node's right is null
        if(root.left == null || root.right == null){
            TreeNode child = node.left != null ? node.left : node.right;

            if(parent == null){
                root = child;
            }
            else{
                if(parent.left == node){
                    parent.left = child;
                }
                else{
                    parent.right = child;
                }
            }
        }
        else{

            //if node has both subtrees at left side and right side
            //We have 2 choices
            //Replace node with largest rightmost node in left subtree
            //Replace node with smallest leftmost node in right subtree

            //taking 1st option
            TreeNode currNode = node.left;
            TreeNode prevNode = node;

            while(currNode.right != null){
                prevNode = currNode;
                currNode = currNode.right;
            }

            node.data = currNode.data;

            if(prevNode.left == currNode){
                prevNode.left = currNode.left;
            }
            else{
                prevNode.right = currNode.left;
            }
        }

        return root;
    }


    public void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        
        DeleteNodeInBST bst = new DeleteNodeInBST();
        bst.createBST();

        System.out.println("BST before deleting the node");
        bst.inorder(bst.root);
        System.out.println();

        bst.root = bst.deleteNode(bst.root, 4);

        System.out.println("BST after deleting the node");
        bst.inorder(bst.root);

    }
}
