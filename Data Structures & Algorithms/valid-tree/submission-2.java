

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 1. Math Check: A tree must have exactly n - 1 edges.
        // If it has fewer, it's disconnected. If it has more, it has a cycle.
        if (edges.length != n - 1) {
            return false;
        }

        // 2. Build Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 3. BFS for Connectivity
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        // Start BFS from node 0
        queue.add(0);
        visited.add(0);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            for (int neighbor : graph.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        
        // 4. If we visited all 'n' nodes, it is a valid tree
        return visited.size() == n;
    }
}