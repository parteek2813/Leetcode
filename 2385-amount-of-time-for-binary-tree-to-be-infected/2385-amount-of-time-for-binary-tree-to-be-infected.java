class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode,TreeNode> p = new HashMap<>();
        // p.put(root,null);
        traversal(root,p);
        HashMap<TreeNode,Integer> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = findNode(root,start);
        System.out.println(node.val); 
        q.add(node);
        map.put(node,0);
        while(!q.isEmpty()){
            TreeNode curr = q.remove();
            int value = map.get(curr);
            // System.out.printl
            if(curr.left != null && !map.containsKey(curr.left)){
                map.put(curr.left,value+1);
                q.add(curr.left);
            }
            if(curr.right != null && !map.containsKey(curr.right)){
                map.put(curr.right,value+1);
                q.add(curr.right);
            }
            if(p.containsKey(curr) && !map.containsKey(p.get(curr))){
                map.put(p.get(curr),value+1);
                q.add(p.get(curr));
            }
        }
        int time = 0;
        for(int level : map.values())
        time = Math.max(time,level);
        // for(var key : map.keySet()){
        //     System.out.print(map.get(key)+" ");
        //     time = Math.max(time,map.get(key));
        // }
        // time = Math.max(time,map.get(key));
        return time;
    }
    public void traversal(TreeNode root,HashMap<TreeNode,TreeNode> p){
        if(root == null)
        return;
        if(root.left != null)
        p.put(root.left,root);
        if(root.right != null)
        p.put(root.right,root);
        traversal(root.left,p);
        traversal(root.right,p);
    }
    public TreeNode findNode(TreeNode root,int start){
        if(root == null)
        return null;
        if(root.val == start)
        return root;
        TreeNode lTree = findNode(root.left,start);
        if(lTree != null)
        return lTree;
        TreeNode rTree = findNode(root.right,start);
        return rTree;
    }
}