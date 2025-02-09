import java.util.ArrayList;
import java.util.List;

public class RootToNodePath{

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

    //Root To Node path
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
    public static void main(String[] args) {
        
        RootToNodePath bt = new RootToNodePath();
        bt.createBinaryTree();

        List<Integer> result = new ArrayList<>();
        //It is not necessary the given node will be present in tree , so you have to check that condition as well
        if(getPath(bt.root, null, result)){
            System.out.println("Root to Node path");
            for(int num : result){
                System.out.print(num + " ");
            }    
        }
        else{
            System.out.println("Node is not present in tree");
        }

        
    }
}