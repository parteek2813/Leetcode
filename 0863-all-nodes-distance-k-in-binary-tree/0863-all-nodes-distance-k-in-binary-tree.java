/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     List<Integer> answer = new ArrayList<>();
//     Map<TreeNode, TreeNode> childParentMap = new HashMap<>();
//     Set<TreeNode> visited = new HashSet<>();
    
//     public List<Integer> distanceK(TreeNode root, TreeNode   target, int k) {
//         findParent(root);
//         depthFirst(target, k);
//         return answer;
//     }
    
//     private void findParent(TreeNode node) {
//         if(node == null) {
//             return;
//         }
//         if(node.left != null) {
//             childParentMap.put(node.left, node);
//             findParent(node.left);
//         }
//         if(node.right != null) {
//             childParentMap.put(node.right, node);
//             findParent(node.right);
//         }
//     }
    
//     private void depthFirst(TreeNode node, int k) {
//         if(node == null || visited.contains(node)) {
//             return;
//         }
//         visited.add(node);
//         if(k == 0) {
//             answer.add(node.val);
//             return;
//         }
//         depthFirst(node.left, k-1);
//         depthFirst(node.right, k-1);
//         depthFirst(childParentMap.get(node), k-1);
//     }
// }


class Solution {
    
    static ArrayList<Integer> arr = new ArrayList<>();
    
    static void addKthNodesHelper(TreeNode root, int k){
        // base case
        if(root == null || k < 0){
            return;
        }
        
        if(k ==0){
            arr.add(root.val);
            return;
        }
        
         
        addKthNodesHelper(root.left, k-1);
        addKthNodesHelper(root.right, k-1);
    }
    
    static int printKthNodes(TreeNode root, TreeNode target, int k){
        // base case
        if(root == null){
            return -1;
        }
        
        // if we find the target node
        if(root == target){
            addKthNodesHelper(root, k);
            return 0;
        }
       
        // rec case
        
        // present in left tree
        int dl = printKthNodes(root.left, target, k);
        if(dl != -1){
            if(dl+1 == k){
                arr.add(root.val);
            }else {
               addKthNodesHelper(root.right, k - dl - 2);
            }
        
            return 1+dl;
        }

        
        // present in right tree
        int dr = printKthNodes(root.right, target, k);
        if(dr != -1){
            if(dr+1 == k){
                arr.add(root.val);
            }else {
                addKthNodesHelper(root.left, k - dr - 2);
            }
        
            return 1+dr;
        }
        
        // not present in both
        return -1;
        
        
    }
    
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        
        arr.clear();
        printKthNodes(root, target, k);
        return arr;
        
    }
}