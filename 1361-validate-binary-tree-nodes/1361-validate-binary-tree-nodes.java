class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Deque<Integer> queue = new ArrayDeque<>(); // Create a queue for BFS traversal.

        Set<Integer> visited = new HashSet<>(); // Create a set to track visited nodes.
        int root = findRoot(n, leftChild, rightChild); // Find the root of the tree.
        if (root == -1) return false; // If there is no valid root, return false.

        queue.offer(root); // Start the BFS from the root node.
        while (!queue.isEmpty()) {
            int node = queue.poll(); // Dequeue a node for processing.
            if (node == -1) continue; // Skip null nodes.

            if (!visited.add(node)) return false; // If the node is visited again, return false.

            int left = leftChild[node];
            int right = rightChild[node];

            queue.offer(left); // Enqueue the left child.
            queue.offer(right); // Enqueue the right child.
        }

        return visited.size() == n; // Check if all nodes have been visited once (i.e., one connected component).
    }
    
    private int findRoot(int n, int[] left, int[] right) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) set.add(i); // Initialize a set with all node indices.
        for (int node : left) set.remove(node); // Remove left child nodes from the set.
        for (int node : right) set.remove(node); // Remove right child nodes from the set.

        return set.size() == 1 ? set.iterator().next() : -1; // Return the root node if there's only one, or -1 if none or multiple.
    }
}