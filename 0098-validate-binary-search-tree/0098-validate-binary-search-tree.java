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

// RECURSIVE CASE: 
// class Solution {
//     public boolean isValidBST(TreeNode root) {
//         return validBstFromFunction(root, Long.MIN_VALUE, Long.MAX_VALUE);
//     }

//     static boolean validBstFromFunction(TreeNode root, long minV, long maxV) {
//         // base case
//         if (root == null) {
//             return true;
//         }

//         // rec case
//         if (root.val > minV && root.val < maxV
//                 && validBstFromFunction(root.left, minV, root.val)
//                 && validBstFromFunction(root.right, root.val, maxV)) {
//             return true;
//         }

//         return false;
//     }
// }


// USING STACK:
import java.util.Stack;

class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            
            // Check if the current node's value is less than or equal to the previous node's value
            if (prev != null && current.val <= prev.val) {
                return false;
            }
            
            prev = current;
            current = current.right;
        }

        return true;
    }
}
