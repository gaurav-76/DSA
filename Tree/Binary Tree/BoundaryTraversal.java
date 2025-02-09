
/*
    Boundary Traversal
    The boundary nodes of a binary tree include the nodes from the left and right boundaries 
    and the leaf nodes, each node considered once.
*/

import java.util.ArrayList;
import java.util.Stack;

public class BoundaryTraversal {

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

    //Boundary Traversal
    //find left boundary nodes excluding leaf nodes
    //find leaf nodes
    //find right boundary node excluding leaf nodes, and put in arraylist in reverse order
    public static boolean isLeafNode(TreeNode root){
        if(root.left == null && root.right == null) return true;
        return false;
    }
    //left boundary
    public static void findLeftBoundary(TreeNode root, ArrayList<Integer> result){
        TreeNode currNode = root.left;
        while(currNode != null){
            if(isLeafNode(currNode) == false) result.add(currNode.data);
            if(currNode.left != null) currNode = currNode.left;
            else currNode = currNode.right;
        }
    }

    //leaf nodes
    public static void findLeafNode(TreeNode root, ArrayList<Integer> result){
        if(isLeafNode(root) == true){
            result.add(root.data);
            return;
        }

        if(root.left != null) findLeafNode(root.left, result);
        if(root.right != null) findLeafNode(root.right, result);
    }

    //right boundary
    public static void findRightBoundary(TreeNode root, ArrayList<Integer> result){
        TreeNode currNode = root.right;
        Stack<Integer> st = new Stack<>();

        while(currNode != null){
            if(isLeafNode(currNode) == false) st.push(currNode.data);
            if(currNode.right != null) currNode = currNode.right;
            else currNode = currNode.left;
        }

        while(!st.isEmpty()){
            result.add(st.pop());
        }
    }
    public static ArrayList<Integer> boundaryT(TreeNode root){
        if(root == null) return new ArrayList<>();

        ArrayList<Integer> result = new ArrayList<>();
        if(isLeafNode(root) == false) result.add(root.data);
        
        findLeftBoundary(root, result);
        //here we are doing inorder traversal, if we use level order traversal then 
        //we will get wrong answer when leaf nodes are not ending at same level
        findLeafNode(root, result);  
        findRightBoundary(root, result);

        return result;
    }
    public static void main(String[] args) {
        
        BoundaryTraversal bt = new BoundaryTraversal();
        bt.createBinaryTree();
        
        ArrayList<Integer> result = bt.boundaryT(root);
        System.out.println("Boundary Traversal");
        for(int num : result){
            System.out.print(num + " ");
        }
    }
}
