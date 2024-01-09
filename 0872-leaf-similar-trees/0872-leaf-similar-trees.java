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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafVals1 = new ArrayList<>();
        List<Integer> leafVals2 = new ArrayList<>();
        dfs(root1, leafVals1);
        dfs(root2, leafVals2);
        return leafVals1.equals(leafVals2);
    }

    private void dfs(TreeNode root, List<Integer> leafVals) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafVals.add(root.val);
            return;
        }
        dfs(root.left, leafVals);
        dfs(root.right, leafVals);
    }
}