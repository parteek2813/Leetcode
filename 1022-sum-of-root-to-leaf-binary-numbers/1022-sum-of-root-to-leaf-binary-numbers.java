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
    
    static int sum =0;
    
    static int findSumOfAll(TreeNode root, int sum){
        
        // base case
        if(root == null){
            return 0;
        }
        
        // sum = (sum<<1) + root.val; 
        sum = 2 * sum + root.val;
        
        if(root.left == null && root.right == null){
            return sum;
        }
        
        // rec case
        
        
        return  findSumOfAll(root.left, sum) + findSumOfAll(root.right, sum);
            
    }
    
    public int sumRootToLeaf(TreeNode root) {
        
        int res = findSumOfAll(root, 0);
        return res;

        
    }
}