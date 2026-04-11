class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0)
            return 0;

        Queue<int[]> rottenFruitsQueue = new LinkedList<>();
        int freshFruits=0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c< grid[0].length; c++){
                if(grid[r][c] == 1){
                    freshFruits++;
                }else if(grid[r][c] == 2){
                    rottenFruitsQueue.offer(new int[]{r,c});
                }
            }
        }
        
        if(freshFruits == 0) 
            return 0;

        int minutePassed=0;
        int[][] dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(!rottenFruitsQueue.isEmpty()){
            //currently avaialbe rotten oranges are size ; and a minute later  neighbours of these oranges will get rotten
            int size = rottenFruitsQueue.size();
            boolean isAnyMarkedRotten =false;
            for(int i=0; i<size; i++){
                int[] current = rottenFruitsQueue.remove();
                //now check all directions from here
                for(int[] dir : dirs){
                    int row = current[0] + dir[0] , col = current[1] + dir[1];
                    //now check if this row and col are fresh fruits then mark them as rotten
                    if(row>=0 && col>=0 && row < grid.length && col < grid[0].length && grid[row][col]==1){
                        isAnyMarkedRotten=true;
                        grid[row][col]=2;
                        freshFruits--;
                        rottenFruitsQueue.offer(new int[]{row,col});
                    }
                }

            }

            if(isAnyMarkedRotten){
                minutePassed++;
            }
        }


        return freshFruits==0 ? minutePassed : -1;
    }
}