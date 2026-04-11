class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length==0)
            return 0;
        
        int count =0;
        for(int r=0; r< grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                if(grid[r][c]=='1'){
                    count++;
                    sinkIsland(r,c,grid);
                }
            }
        }
        return count;
    }

    private void sinkIsland(int row,int col ,char[][] grid){
        if(row<0 || col <0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0'){
            return;
        }
        //mark as visited and sank / water
        grid[row][col] = '0';
        //check near neighbours
        sinkIsland(row+1,col,grid);
        sinkIsland(row,col+1,grid);
        sinkIsland(row-1,col,grid);
        sinkIsland(row,col-1,grid);
    }
}