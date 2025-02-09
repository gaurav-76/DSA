/*
    Given the root of a binary tree, calculate the vertical order traversal of the binary tree.

    For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) 
    and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

    The vertical order traversal of a binary tree is a list of top-to-bottom orderings for 
    each column index starting from the leftmost column and ending on the rightmost column. 
    There may be multiple nodes in the same row and same column. In such a case, sort these nodes by 
    their values.

    Return the vertical order traversal of the binary tree.

*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalOrderTraversal {

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
    
        class Tuple{
            TreeNode node;
            int x;
            int y;
    
            public Tuple(TreeNode node, int x, int y){
                this.node = node;
                this.x = x;
                this.y = y;
            }
        }
        //Vertical Order Traversal
        // go left -1
        // go right +1
        public List<List<Integer>> verticalOrder(TreeNode root){

            if(root == null) return new ArrayList<>();
            
            List<List<Integer>> result = new ArrayList<>();
            //{X level , {Y level, Each levels all element in sorted order}}
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
            Queue<Tuple> que = new LinkedList<>(); //queue will use for traversal
            que.offer(new Tuple(root, 0, 0));
            
            while(!que.isEmpty()){
                Tuple obj = que.poll();
                TreeNode currNode = obj.node;
                int x = obj.x;
                int y = obj.y;
            
                if(!mp.containsKey(x)){
                    mp.put(x, new TreeMap<>());
                }
                        
                if(!mp.get(x).containsKey(y)){
                    mp.get(x).put(y, new PriorityQueue<>());
                }
            
                mp.get(x).get(y).add(currNode.data);
            
                if(currNode.left != null) que.offer(new Tuple(currNode.left, x-1, y+1));
                if(currNode.right != null) que.offer(new Tuple(currNode.right, x+1, y+1));
            }
            
            //now we need to put data in result
            for(TreeMap<Integer, PriorityQueue<Integer>> x : mp.values()){
                List<Integer> col = new ArrayList<>();
                for(PriorityQueue<Integer> y: x.values()){
                    col.addAll(y);
                }
                    result.add(col);
            }
            return result;
        }
            
        public static void main(String[] args) {
                    
            VerticalOrderTraversal bt = new VerticalOrderTraversal();
            bt.createBinaryTree();

            List<List<Integer>> result = bt.verticalOrder(bt.root);
            System.out.println("Vertical Order Traversal");

            for(List<Integer> list : result){
                for(int num : list){
                    System.out.print(num + " ");
                }
                System.out.println();
            }
    }
}
