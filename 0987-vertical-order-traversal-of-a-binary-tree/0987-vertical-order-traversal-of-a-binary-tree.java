import java.util.*;

class Solution {
    static void PrintTreeDist(TreeNode root, int dist, int level, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }

        if (!map.containsKey(dist)) {
            map.put(dist, new TreeMap<>());
        }
        if (!map.get(dist).containsKey(level)) {
            map.get(dist).put(level, new ArrayList<>());
        }
        map.get(dist).get(level).add(root.val);

        PrintTreeDist(root.left, dist - 1, level + 1, map);
        PrintTreeDist(root.right, dist + 1, level + 1, map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        PrintTreeDist(root, 0, 0, map);

        List<List<Integer>> result = new ArrayList<>();
        for (int dist : map.keySet()) {
            List<Integer> tempList = new ArrayList<>();
            TreeMap<Integer, List<Integer>> levelMap = map.get(dist);
            for (List<Integer> levelList : levelMap.values()) {
                Collections.sort(levelList);
                tempList.addAll(levelList);
            }
            result.add(tempList);
        }

        return result;
    }
}
