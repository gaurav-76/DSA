import java.util.ArrayList;
import java.util.List;

public class LowestCommonAncestor {

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

    public static boolean getPath(TreeNode root, TreeNode node, List<Integer> result){
        if(root == null){
            return false;
        }
        
        result.add(root.data);

        if(root == node) return true;

        boolean left = getPath(root.left, node, result);
        boolean right = getPath(root.right, node, result);

        if(left || right) return true;

        result.remove(result.size() - 1);
        return false;
    }

    //Apprach 1
    //We will store path in 2 list
    //then we traverse list , the last element which is common in both list
    //will be the lca

    //We are expecting that p and q is present in tree
    public int approach1(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return -1;
        }

        List<Integer> list1 = new ArrayList<>();
        getPath(root, p, list1);

        List<Integer> list2 = new ArrayList<>(); 
        getPath(root, q, list2);

        int l1 = list1.size();
        int l2 = list2.size();
        int i = 0, j = 0;
        while(i < l1 && j < l2){
            if(list1.get(i) != list2.get(j)){
                break;
            }
            ++i;
            ++j;
        }

        return list1.get(i-1);
    }

    //Approach 2
    //if we find both node we will return our root
    //now we traverse left and right
    //if we get any node we will return that
    public TreeNode approach2(TreeNode root, TreeNode p, TreeNode q){

        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left   = approach2(root.left, p, q);
        TreeNode right  = approach2(root.right, p, q);

        if(left != null && right != null){
            return root;
        }

        if(left != null){
            return left;
        }

        return right;
    }

    public static void main(String[] args) {
        
        LowestCommonAncestor bt = new LowestCommonAncestor();
        bt.createBinaryTree();

        TreeNode p = root.right.right;
        TreeNode q = root.left; 
        //Brute force
        System.out.println("Lowest Common Ancestor : " + bt.approach1(root, p, q));
        
        //Optimal Approach
        System.out.println("Lowest Common Ancestor : " + bt.approach2(root, p, q).data);
    }
}
