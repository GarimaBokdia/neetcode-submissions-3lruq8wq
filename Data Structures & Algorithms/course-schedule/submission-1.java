class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 1. Build Adjacency List
        List<List<Integer>> graph = new ArrayList<>();
        //numCourses are nodes and prerequistes are edges to make this complete graph
        for(int i=0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] pair : prerequisites){
            //direction of edge going from pair[1] to pair[0] ; i.e.e index[1] is prerequistie for index[0]
            graph.get(pair[1]).add(pair[0]);
        }
        /*
        We use an integer array state[] for this:

        0: Unvisited.

        1: Visiting (Currently in the recursion path). <-- DANGER ZONE

        2: Visited (Safe, processed successfully).*/

        int[] visited = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            if(visited[i] == 0){
                if(hasCycle(graph,visited,i))
                    return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph , int[] visited, int currNode){
        if(visited[currNode] == 1){
            return true;
        }

          
        visited[currNode] = 1;

        for(int neighbour : graph.get(currNode)){
            if(visited[neighbour] !=2){
            if(hasCycle(graph,visited,neighbour)){
                return true;
            }
            }
        }

        visited[currNode] = 2;
        return false;
    }
}