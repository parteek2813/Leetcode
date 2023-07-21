import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

//  USING RECURSION:
// class Solution {
    
//     static void searchBt(TreeNode root, String s ,List<String> arr ){
//         // base case
//         if(root.left == null && root.right == null){
//             arr.add(s + root.val);
            
//         }
        
//         // rec case
//         if(root.left != null){
//             searchBt(root.left, s + root.val + "->" , arr);
//         }
        
//         if(root.right != null){
//              searchBt(root.right , s + root.val + "->" , arr);
//         }
        
        
//     }
//     public List<String> binaryTreePaths(TreeNode root) {
//         ArrayList<String> arr = new ArrayList<String>();
        
        
//         if(root != null){
//             searchBt(root, "" , arr);
//         }
        
//         return arr;
  
            
//     }
// }


// USING STACK


 class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        if (root == null)
            return res;

        Stack<Pair<TreeNode, String>> stack = new Stack<>();
        stack.push(new Pair<>(root, ""));

        while (!stack.isEmpty()) {
            Pair<TreeNode, String> pair = stack.pop();
            TreeNode node = pair.getKey();
            String ls = pair.getValue();

            if (node.left == null && node.right == null) {
                res.add(ls + node.val);
            }

            if (node.right != null) {
                stack.push(new Pair<>(node.right, ls + node.val + "->"));
            }

            if (node.left != null) {
                stack.push(new Pair<>(node.left, ls + node.val + "->"));
            }
        }

        return res;
    }
}
