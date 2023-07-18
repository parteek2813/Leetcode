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

// Time-O(log n), worst case - O(Height of tree) , Space- O(1) 


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


// Recursive code: TIME:

// Time- O(log n), worst case- O(Height of tree) , Space- O(N) in storing in stack 

// class Solution {
//     public TreeNode searchBST(TreeNode root, int val) {
//         // base case
//         if( root == null){
//             return null;
//         }
        
//         if(root.val == val){
//             return root;
//         }else if(val <= root.val){
//             return searchBST(root.left,val);
//         }else{
//             return searchBST(root.right, val);
//         }
        
        
//     }
    
// }


class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val){
            return root;
        }
        
        
        // For first root,. just store in stack!
        Stack<TreeNode> sc = new Stack<>();
        if (root.val > val) {
            sc.push(root.left);
        } else {
            sc.push(root.right);
        }
        
        
        while(!sc.isEmpty()){
            TreeNode currNode = sc.pop();
            if(currNode != null){
                if(currNode.val == val){
                    return currNode; // if popped node == val, then return this Node
                }
                // Add curr Node and then pop and then see if it equals val iteratively
                if(currNode.val> val){
                    sc.push(currNode.left);
                }else{
                    sc.push(currNode.right);
                }
            }
        }
        return null;
       
    }
}