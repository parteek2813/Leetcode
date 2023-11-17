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
    int currCount=0;
    int currVal=0;
    int maxCount=0;
    List<Integer> list=new ArrayList();
    public int[] findMode(TreeNode root) {
        
        findModeval(root);
        
        int[] arr=new int[list.size()];
        for(int i=0;i<list.size();i++)
        {
            arr[i]=list.get(i);
        }
        return arr;
    }
    public void findModeval(TreeNode root)
    {
        if(root==null)
        {
            return ;
        }
        findModeval(root.left);
        currCount=currVal==root.val ? currCount+1 : 1;
        if(currCount==maxCount)
        {
            list.add(root.val);
        }else if(currCount>maxCount)
        {
            list.clear();
            list.add(root.val);
            maxCount=currCount;
        }
        currVal=root.val;
        findModeval(root.right);
    }
}