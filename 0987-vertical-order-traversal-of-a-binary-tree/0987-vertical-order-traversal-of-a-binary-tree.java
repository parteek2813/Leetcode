import java.util.*;

class Solution {
    // Method to perform vertical traversal and store nodes in a TreeMap
    static void PrintTreeDist(TreeNode root, int dist, int level, TreeMap<Integer, TreeMap<Integer, List<Integer>>> map) {
        if (root == null) {
            return;
        }

        // Check if the TreeMap contains the vertical distance
        if (!map.containsKey(dist)) {
            // If not present, add a new TreeMap for the given vertical distance
            map.put(dist, new TreeMap<>());
        }
        // Check if the TreeMap for the vertical distance contains the level
        if (!map.get(dist).containsKey(level)) {
            // If not present, add a new list for the given level
            map.get(dist).put(level, new ArrayList<>());
        }
        // Add the node value to the list at the specified vertical distance and level
        map.get(dist).get(level).add(root.val);

        // Recursively traverse the left and right subtrees
        PrintTreeDist(root.left, dist - 1, level + 1, map);
        PrintTreeDist(root.right, dist + 1, level + 1, map);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Create a TreeMap to store the nodes based on vertical distance and level
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        // Perform vertical traversal and populate the TreeMap
        PrintTreeDist(root, 0, 0, map);

        // Create a list to store the final result
        List<List<Integer>> result = new ArrayList<>();
        // Iterate over the TreeMap keys (vertical distances)
        for (int dist : map.keySet()) {
            // Create a temporary list to store the node values at the current vertical distance
            List<Integer> tempList = new ArrayList<>();
            // Get the TreeMap for the current vertical distance
            TreeMap<Integer, List<Integer>> levelMap = map.get(dist);
            // Iterate over the TreeMap values (levels)
            for (List<Integer> levelList : levelMap.values()) {
                // Sort the list of node values
                Collections.sort(levelList);
                // Add the sorted node values to the temporary list
                tempList.addAll(levelList);
            }
            // Add the temporary list to the final result
            result.add(tempList);
        }

        // Return the final result
        return result;
    }
}
