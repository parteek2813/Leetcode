/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    static void searchBt(TreeNode root, String s ,List<String> arr ){
        // base case
        if(root.left == null && root.right == null){
            arr.add(s + root.val);
            
        }
        
        // rec case
        if(root.left != null){
            searchBt(root.left, s + root.val + "->" , arr);
        }
        
        if(root.right != null){
             searchBt(root.right , s + root.val + "->" , arr);
        }
        
        
    }
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> arr = new ArrayList<String>();
        
        
        if(root != null){
            searchBt(root, "" , arr);
        }
        
        return arr;
  
            
    }
}