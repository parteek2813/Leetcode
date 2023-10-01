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
    
     private static TreeNode construct(int[] nums, int s, int e){
        if(s>e) return null;
        if(s==e) return new TreeNode(nums[s]);
        
        
        int idx = findMax(nums, s , e);
        TreeNode root = new TreeNode(nums[idx]);
        root.left = construct(nums, s, idx-1);
        root.right = construct(nums, idx+1, e);
        
        
            return root;
    }
    
    public TreeNode ConstructMaxBinaryTreeStack(int[] nums){
        Stack<TreeNode> stack = new Stack<>();
        
        for (int num : nums) {
            TreeNode currentNode = new TreeNode(num);
            while (!stack.isEmpty() && num > stack.peek().val) {
                currentNode.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = currentNode;
            }
            stack.push(currentNode);
        }
        return stack.isEmpty() ? null : stack.firstElement();
    }
    
    private static int findMax(int[] arr, int s , int e){
        int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i =s; i<=e; i++){
            if(arr[i] > max){
                max = arr[i];
                idx = i;
            }
        }
        
        return idx;
    }
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // TreeNode root = construct(nums, 0, nums.length -1);
        // return root;
        
        
        return ConstructMaxBinaryTreeStack(nums);
    }
}