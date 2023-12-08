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
    public String tree2str(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        DFS( root, sb );
        return sb + "";
    }
    
    private void DFS( TreeNode root, StringBuilder sb ){
        if( root == null ) 
            return;
        sb.append( String.valueOf( root.val ) ); 
        
        if( root.left == null && root.right == null ) 
            return;

        
        

        sb.append( '(' );
        DFS( root.left, sb );
        sb.append( ')' );

        if( root.right != null ){ 
            sb.append( '(' );
            DFS( root.right, sb );
            sb.append( ')' );
        }
    }
}