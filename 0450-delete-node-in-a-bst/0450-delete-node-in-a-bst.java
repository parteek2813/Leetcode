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
//  */


// class Solution {
//     public TreeNode deleteNode(TreeNode root, int key) {
//         // searching
//         if(root == null){
//             return null;
//         }
        
//         // key is less than root
//         if(key < root.val){
//             root.left = deleteNode(root.left, key);
//             return root;
//         }
        
//         // key is greater than root
//         else if(key > root.val){
//             root.right = deleteNode(root.right, key);
//             return root;
//         }
        
        
//         // deletion
//         // key == root (this node should be deleted)
//         // no child, 1 child, 2 child
//         else{
//             // if deletion node is leaf node , just return from it
            
//             // no child
//             if(root.left == null && root.right == null){
//                 return null;
//             }
//             // 1 child
//             else if(root.left != null && root.right == null){
//                 return root.left;
//             }else if(root.left == null && root.right != null){
//                 return root.right;
//             }
            
//             else{
//                 // 2 children
//                 TreeNode temp = root.left;
//                 // find max
//                 while(temp.right != null){
//                     temp = temp.right; // go to exteme right
//                 }
//                 // replace root data with largest in LST
//                 root.val = temp.val;
                
//                 // delete the largest node too at last
//                 root.left = deleteNode(root.left,temp.val);
                
//                 return root;
                
//             }
//         }
//     }
// }


import java.util.Stack;

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // Stack for iterative traversal
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        TreeNode parent = null;

        // Find the node to delete
        while (current != null && current.val != key) {
            parent = current;
            if (key < current.val) {
                stack.push(current);
                current = current.left;
            } else {
                stack.push(current);
                current = current.right;
            }
        }

        // If the node is not found, return the original root
        if (current == null) {
            return root;
        }

        // Deletion
        if (current.left == null && current.right == null) {
            // No child
            if (parent == null) {
                return null;
            } else if (parent.left == current) {
                parent.left = null;
            } else {
                parent.right = null;
            }
        } else if (current.left != null && current.right == null) {
            // One child (left child)
            if (parent == null) {
                return current.left;
            } else if (parent.left == current) {
                parent.left = current.left;
            } else {
                parent.right = current.left;
            }
        } else if (current.left == null && current.right != null) {
            // One child (right child)
            if (parent == null) {
                return current.right;
            } else if (parent.left == current) {
                parent.left = current.right;
            } else {
                parent.right = current.right;
            }
        } else {
            // Two children
            TreeNode temp = current.left;
            TreeNode tempParent = current;
            while (temp.right != null) {
                tempParent = temp;
                temp = temp.right;
            }

            current.val = temp.val;
            if (tempParent.right == temp) {
                tempParent.right = temp.left;
            } else {
                tempParent.left = temp.left;
            }
        }

        return root;
    }
}
