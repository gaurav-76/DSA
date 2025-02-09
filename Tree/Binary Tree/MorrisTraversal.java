import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MorrisTraversal {

    private class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
    }

    private TreeNode root;
    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        
        /*
                    1
                  /   \
                 2     3
                /  \    \
               4    5    6  
              /         /
             7         8
        */
    
        root = first;
        first.left = second;
        first.right = third;
        
        second.left = fourth;
        second.right = fifth;
        
        third.right = sixth;
    
        fourth.left = seventh;
    
        sixth.left = eight;
    }

    //Morris Traversal for Inorder
    public void MorrisTraversalInorder(TreeNode root){
        
        if(root == null) return;

        TreeNode curr = root;
        while(curr != null){
            
            // If left child is null, print the 
            // current node data. Move to  right child. 
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else{
                // Find inorder predecessor 
                TreeNode leftChild = curr.left;
                while(leftChild.right != null && leftChild.right != curr){
                    leftChild = leftChild.right;
                }

                // If the right child of inorder predecessor is null
                // establish a link back to the current node
                if(leftChild.right == null){
                    leftChild.right = curr;
                    curr = curr.left;
                }
                else{
                    // restore the tree structure
                    // when the left's rightmost child points to curr node already 
                    // if thread is already pointed to current node, then remove the thread
                    leftChild.right = null;
                    System.out.print(curr.data + " ");
                    curr = curr.right;        
                }

            }
        }
    }

        //Morris Traversal for PreOrder
    public void MorrisTraversalPreorder(TreeNode root){
        
        if(root == null) return;

        TreeNode curr = root;
        while(curr != null){
            
            // If left child is null, print the 
            // current node data. Move to  right child. 
            if(curr.left == null){
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
            else{
                // Find inorder predecessor 
                TreeNode leftChild = curr.left;
                while(leftChild.right != null && leftChild.right != curr){
                    leftChild = leftChild.right;
                }

                // If the right child of inorder predecessor is null
                // establish a link back to the current node
                if(leftChild.right == null){
                    leftChild.right = curr;
                    System.out.print(curr.data + " ");
                    curr = curr.left;
                }
                else{
                    // restore the tree structure
                    // when the left's rightmost child points to curr node already 
                    // if thread is already pointed to current node, then remove the thread
                    leftChild.right = null;
                    curr = curr.right;        
                }

            }
        }
    }

    //Morris Traversal for PostOrder
    public void MorrisTraversalPostorder(TreeNode root){
        if(root == null) return;

        List<Integer> result = new ArrayList<>();

        //We will apply morris in reverse way for postorder
        //same code of morris preorder
        //we replaced left = right
        //            right = left
        TreeNode curr = root;
        while(curr != null){
            
            // If left child is null, print the 
            // current node data. Move to  right child. 
            if(curr.right == null){
                result.add(curr.data);
                curr = curr.left;
            }
            else{
                // Find inorder predecessor 
                TreeNode leftChild = curr.right;
                while(leftChild.left != null && leftChild.left != curr){
                    leftChild = leftChild.left;
                }

                // If the right child of inorder predecessor is null
                // establish a link back to the current node
                if(leftChild.left == null){
                    leftChild.left = curr;
                    result.add(curr.data);
                    curr = curr.right;
                }
                else{
                    // restore the tree structure
                    // when the left's rightmost child points to curr node already 
                    // if thread is already pointed to current node, then remove the thread
                    leftChild.left = null;
                    curr = curr.left;        
                }

            }
        }

        //now reverse list
        Collections.reverse(result);
        
        for(int num : result){
            System.out.print(num + " ");
        }

    }
    public static void main(String[] args) {
        
        MorrisTraversal bt = new MorrisTraversal();
        bt.createBinaryTree();

        System.out.println("Morris Traversal Inorder");
        bt.MorrisTraversalInorder(bt.root); // 7 4 2 5 1 3 8 6

        System.out.println();

        System.out.println("Morris Traversal Preorder");
        bt.MorrisTraversalPreorder(bt.root); // 1 2 4 7 5 3 6 8

        System.out.println();

        System.out.println("Morris Traversal Postorder");
        bt.MorrisTraversalPostorder(bt.root); // 7 4 5 2 8 6 3 1
        
    }
}
