class Solution {
    int ans = 0;
    public int maxAncestorDiff(TreeNode root) {
        f(root, root.val, root.val);
        return ans;
    }
    void f(TreeNode root, int min, int max){
        if(root==null) return;
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);
        ans = Math.max(ans, Math.abs(min-root.val));
        ans = Math.max(ans, Math.abs(max-root.val));
        f(root.left,min,max);
        f(root.right,min,max);
    }
}