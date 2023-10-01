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
    
    static int index = 0;
     
    
    public static TreeNode constructBst(int[] preorder, int bound){
        
        // if currentElement is greater than bound[previus element] , then just return,... otherwise make the tree.
        if(index == preorder.length || preorder[index] > bound){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[index++]);
        
        root.left = constructBst(preorder, root.val);
        root.right = constructBst(preorder, bound);
        
        return root;
        
    }
    
    private TreeNode buildBST(int[] preorder, int start, int end) {
        if (start > end) {
          return null;
        }

        int value = preorder[start];
        TreeNode root = new TreeNode(value);

        
        // The main logic here is that jab tak preorder[i] less hein value se 
        // tab tak i ko increment karate raho isse.... sare less element left taraf aajayenge simple
        
        
        int i;
        for (i=start+1; i<=end; i++) {
          if (preorder[i] > value) {
            break; 
          }
        }

        root.left = buildBST(preorder, start+1, i-1);
        root.right = buildBST(preorder, i, end);
        return root;
    }
    
    
    public TreeNode bstFromPreorder(int[] preorder) {
        
       // return constructBst(preorder, Integer.MAX_VALUE);
        
         return buildBST(preorder, 0, preorder.length - 1);
    }
}