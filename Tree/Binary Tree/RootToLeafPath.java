import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {

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

    //Root to leaf path
    public void getRootToLeafPath(TreeNode root, List<List<Integer>> result, List<Integer> temp){

        if(root == null) return;

        temp.add(root.data);
        if(root.left == null && root.right == null){
            //we got 1 path
            //here we are directly adding temp reference so if we made any modification
            //in temp this will also impact our resut
            //result.add(temp);

            //instead add copy
            // Add a copy of the current path to the result
            result.add(new ArrayList<>(temp));
        }
        
        getRootToLeafPath(root.left, result, temp);
        getRootToLeafPath(root.right, result, temp);
        temp.remove(temp.size()-1);   
    }
    public static void main(String[] args) {
        
        RootToLeafPath bt = new RootToLeafPath();
        bt.createBinaryTree();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        bt.getRootToLeafPath(root, result, temp);

        System.out.println("Root to Leaf Path");
        for(List<Integer> list : result){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
