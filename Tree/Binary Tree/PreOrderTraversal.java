import java.util.Stack;

public class PreOrderTraversal {
    
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
    
    //pre order recursive approach
    public void preOrder(TreeNode root){
        if(root == null) return;
    
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    
    //pre order interative approach
    public void preOrderIterative(TreeNode root){
        if(root == null) return;
    
        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){
            TreeNode currNode = st.pop();

            System.out.print(currNode.data + " ");
            
            //as we need to get first left then right but stack follow LIFO
            //so first we insert right node then left
            //so that while popping we can get left node first
            if(currNode.right != null){
                st.push(currNode.right);
            }

            if(currNode.left != null){
                st.push(currNode.left);
            }
        }
    }
    public static void main(String[] args) {
            
        PreOrderTraversal pt = new PreOrderTraversal();
        pt.createBinaryTree();
        System.out.print("PreOrder Traversal : ");
        //pt.preOrder(root);
        pt.preOrderIterative(root); //o/p : 1 2 4 5 3 6
    }
}
