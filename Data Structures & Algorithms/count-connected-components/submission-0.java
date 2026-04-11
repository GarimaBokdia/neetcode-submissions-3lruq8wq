class Solution {
    public int countComponents(int n, int[][] edges) {
        //UNION FIND 
        int components = n;
        //creating a parents array
        int[] parents = new int[n];
        for(int i=0; i<n; i++){
            parents[i] = i;
        }

        //checking the edges , finding their leaders, grouping them as and when required
        for(int[] edge : edges){
            int leaderA = findParent(parents,edge[0]);
            int leaderB = findParent(parents,edge[1]);

            if(leaderA != leaderB){
                //merge them
                parents[leaderA] = leaderB;
                components--;
            }
        }
        return components;
    }

    private int findParent(int[]  parents, int node){
        if(parents[node] == node){
            return node;
        }

        parents[node] = findParent(parents, parents[node]);
        return parents[node];
    }
}
