import java.util.Stack;

public class InOrderTraversal {

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

    //recursive approach
    public void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    //Iterative approach
    //temp variable is used to point to left node of every subtree
    //then point to right
    public void inOrderIterative(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> st = new Stack<>();
        TreeNode temp = root;

        while(!st.isEmpty() || temp != null){
            if(temp != null){
                st.push(temp);
                temp = temp.left; //now we move temp to next left node
            }
            else{
                //if temp is null means , temp is reached to leftmost node of current subtree
                temp = st.pop();
                System.out.print(temp.data + " ");
                temp = temp.right; //now temp will be moved to right side
            }
        }
    }
    public static void main(String[] args) {
        
        InOrderTraversal pt = new InOrderTraversal();
        pt.createBinaryTree();
        System.out.print("InOrder Traversal : ");
        //pt.inOrder(root);
        pt.inOrderIterative(root); //o/p : 4 2 5 1 3 6
    }
}
