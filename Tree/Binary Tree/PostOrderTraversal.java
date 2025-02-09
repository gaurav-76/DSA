import java.util.Stack;

public class PostOrderTraversal {

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
    public void postOrder(TreeNode root){
        if(root == null) return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    //Iterative approach 2 stack used
    public void postOrderIterative1(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> st1 = new Stack<>(); //in this stack we store that node whose is going to processed in next step
        Stack<TreeNode> st2 = new Stack<>(); //this stack is used to store post order traversal
        //instead of this st2 we can use vector and in last we can start printing from last
        //this will avoid using 2 stack

        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);  //storing postorder

            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }

        while(!st2.isEmpty()){
            System.out.print(st2.pop().data + " ");
        }
    }

    public void postOrderIterative2(TreeNode root){
        if(root == null) return;

        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                TreeNode temp = st.peek().right;
                if(temp == null){ //we reached at a point where the node don't have any left and right child
                    temp = st.pop(); //take top element
                    System.out.print(temp.data + " ");

                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.pop();
                        System.out.print(temp.data + " ");
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
       
        PostOrderTraversal pt = new PostOrderTraversal();
        pt.createBinaryTree();
        System.out.print("PostOrder Traversal : ");
        //pt.postOrder(root);
        //pt.postOrderIterative1(root); // 2 stack used , o/p : 4 5 2 6 3 1
        pt.postOrderIterative2(root);

    }
}
