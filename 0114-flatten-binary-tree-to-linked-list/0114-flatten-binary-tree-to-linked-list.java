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

class Pair {
    TreeNode head;
    TreeNode tail;
    
    Pair(TreeNode head, TreeNode tail){
        this.head = head;
        this.tail = tail;
    }
}

class Solution {
    
    static Pair ConvertTree2LL(TreeNode root){
        
        if (root == null) {
            return null;
        }
        
        Pair leftLL = ConvertTree2LL(root.left);
        Pair rightLL = ConvertTree2LL(root.right);
        
        if(leftLL != null){
            leftLL.tail.right = root.right;
            root.right = root.left;
            root.left = null;
            
        }
        
        if(rightLL != null){
            return new Pair(root, rightLL.tail);
        }    
    

        if(leftLL != null){
            return new Pair(root, leftLL.tail);
        }
        
        return new Pair(root, root);
       
        
    }
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        
        ConvertTree2LL(root);
            
        
        
    }
}