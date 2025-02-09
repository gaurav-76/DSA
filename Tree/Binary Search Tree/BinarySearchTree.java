import java.util.LinkedList;
import java.util.Queue;

//L.C - 1008. Construct Binary Search Tree from Preorder Traversal

class BinarySearchTree{

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

    //create BST through array Recursive Approach
    // public TreeNode createBST(TreeNode root, int val){

    //     //we need to create node
    //     if(root == null){
    //         TreeNode newNode = new TreeNode(val);
    //         return newNode;
    //     }

    //     if(val < root.data){
    //         root.left = createBST(root.left, val);
    //     }
    //     else{
    //         root.right = createBST(root.right, val);
    //     }

    //     return root;
    // }

    //create BST through array Iterative Approach
    public TreeNode createBST(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }

        TreeNode curr = root;
        while(true){
            if(val < curr.data){
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
            else{
                if(curr.right != null){
                    curr = curr.right;
                }   
                else{
                    curr.right = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }
    //inorder traversal
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public void levelOrder(TreeNode root){
        
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int level = 1;

        while(!que.isEmpty()){
            int size = que.size();

            System.out.print("Level " + level + " : ");
            for(int i = 0; i < size; ++i){
                TreeNode currNode = que.poll();
                System.out.print(currNode.data + " ");

                if(currNode.left != null) que.offer(currNode.left);
                if(currNode.right != null) que.offer(currNode.right);
            }
            level++;
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        int[] arr = {5, 3, 7, 2, 1, 6, 9, 8, 10, 4};

        BinarySearchTree bst = new BinarySearchTree();
        
        for(int i = 0; i < arr.length; ++i){
            bst.root = bst.createBST(bst.root, arr[i]);
        }


        //Now we call inorder method, because if tree made correctly
        //then in inorder all element will print in sorted order
        System.out.println("Inorder traversal of BST");
        bst.inorder(bst.root);
       
        System.out.println();
        
        System.out.println("Level order traversal of BST");
        bst.levelOrder(bst.root);
        
    }
}