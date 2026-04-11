class Solution {
    public boolean validTree(int n, int[][] edges) {
        // a tree is an undirected graph with no cycles, all the nodes are connected as one component, and any two nodes have exactly one path
        //Tree wil have exactly n-1 edges 

        if(edges.length != n-1)
            return false;

        //Ceating adjacency matrix
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i< n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges ){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        //BFS for connectivity
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited.add(0);
        while(!queue.isEmpty()){
            int currNode = queue.poll();
            for(int neighbour :  graph.get(currNode)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }

        return visited.size() == n; 
    }
}
