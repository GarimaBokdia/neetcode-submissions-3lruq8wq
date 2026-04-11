class Solution {
    public int uniquePaths(int m, int n) {
        /*
        int[][] dp = new int[m][n];
         for(int i=0;i<m; i++ ){
            dp[i][0]=1;
         }

        for(int j=0; j<n; j++){
            dp[0][j] =1;
        }
       

        for(int i=1;i<m;i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];*/

        /*
        In the 2D version, the formula is: Current_Cell = Top_Neighbor + Left_Neighbor

        In the 1D version, we use a single array row[] to represent the current row we are working on. But before we update a cell, that cell holds the value from the previous row (the Top neighbor).

        row[j] (Old Value) = This effectively is the Top neighbor (because we haven't updated it yet, so it still holds the value from the row above).

        row[j-1] (New Value) = This effectively is the Left neighbor (because we just updated it a millisecond ago).

        So the code row[j] = row[j] + row[j-1] is actually translating to row[j] = Top + Left.

        reduced space complexity of O(N)
        */
//Time complexities in both the solution is O(m * N)
        int row[] = new int[n];

        Arrays.fill(row,1); //top

        //Values in column 0 are to be the 1

        for(int i=1; i<m ; i++){
            for(int j=1; j<n;j++){
                //new value in the cell = old value in the cell (TOP)+ value in the previou s column  
                row[j] = row[j] + row[j-1] ; 
            }
        }
        return row[n-1];
    }
}