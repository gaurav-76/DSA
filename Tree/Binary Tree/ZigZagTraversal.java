
/*
    ZigZag Level Order Traversal
    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. 
    (i.e., from left to right, then right to left for the next level and alternate between).

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

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

    //ZigZag Traversal T.c : o(n)
    public static List<List<Integer>> zzTraversal(TreeNode root){

        if(root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);

        boolean leftToRight = true;

        while(!que.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = que.size();

            for(int i = 0; i < size; ++i){
                TreeNode currNode = que.poll();

                if(leftToRight){
                    list.add(currNode.data); //follow left to right
                }
                else{
                    list.add(0, currNode.data); //follow reverse order right to left
                }

                if(currNode.left != null) que.offer(currNode.left);
                if(currNode.right != null) que.offer(currNode.right);
            }

            leftToRight = !leftToRight;
            result.add(list);

        }
        return result;
    }

    public static void main(String[] args) {
        ZigZagTraversal bt = new ZigZagTraversal();
        bt.createBinaryTree();
        
        List<List<Integer>> result = zzTraversal(root);
        
        System.out.println("Zig Zag Traversal");
        for(List<Integer> list : result){
            for(int num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
