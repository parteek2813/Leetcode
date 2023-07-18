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


//  Iterative code:
// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         while(root != null){
            
//             if(val == root.val){
//                 return root;
//             }else if(val<= root.val){
//                 root = root.left;
//             }else{
//                 root = root.right;
//             }
//         }
//         return null;
//     }
// }


// Recursive code:

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // base case
        if(root == null){
            return null;
        }
        
        if(root.val == val){
            return root;
        }else if(val <= root.val){
            return searchBST(root.left,val);
        }else{
            return searchBST(root.right, val);
        }
        
        
    }
    
}
