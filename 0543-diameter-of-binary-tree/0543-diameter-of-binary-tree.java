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
    
    static int height(TreeNode root){
        if(root == null){
            return 0;
            
        }
        
        
        int h1 = height(root.left);
        int h2 = height(root.right);
        
        return Math.max(h1,h2) + 1;
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
            
        }
        
        // rec case
        int hl = height(root.left);
        int hr = height(root.right);
        int d1 = hl + hr;
        int d2 = diameterOfBinaryTree(root.left);
        int d3 = diameterOfBinaryTree(root.right);
        return Math.max(d1, Math.max(d2, d3));
        
    }
}