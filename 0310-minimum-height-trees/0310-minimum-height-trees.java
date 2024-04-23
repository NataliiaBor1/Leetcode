class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

            // Build the adjacency list
            List<Set<Integer>> adj = new ArrayList<>(n);
            for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
            for (int[] edge : edges) {
                adj.get(edge[0]).add(edge[1]);
                adj.get(edge[1]).add(edge[0]);
            }

            // Initialize the first layer of leaves
            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (adj.get(i).size() == 1) leaves.add(i);
            }

            // Trim the leaves until reaching the centroids
            while (n > 2) {
                n -= leaves.size();
                List<Integer> newLeaves = new ArrayList<>();

                for (int i : leaves) {
                    // the only neighbor of a leaf node
                    int j = adj.get(i).iterator().next();
                    adj.get(j).remove(i);
                    if (adj.get(j).size() == 1) newLeaves.add(j);
                }
                leaves = newLeaves;
            }

            return leaves;
    }
}