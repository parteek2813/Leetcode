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

    static ArrayList<Integer> findRightView(TreeNode root, int lvl, ArrayList<Integer> result) {
        if (root == null) {
            return result;
        }

        if (lvl > result.size()) {
            result.add(root.val);
        }

        // Traverse right subtree first to get the rightmost nodes
        findRightView(root.right, lvl + 1, result);
        findRightView(root.left, lvl + 1, result);

        return result;
    }

    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        findRightView(root, 1, result);
        return result;
    }
}

