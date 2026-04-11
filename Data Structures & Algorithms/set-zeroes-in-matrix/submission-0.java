class Solution {
    //non optimised version with O(M+N) space          
    /*public void setZeroes(int[][] matrix) {
        if(matrix == null)
            return ;
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean[] rowTracking = new boolean[rows] , colTracking = new boolean[cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(matrix[i][j] == 0){
                    rowTracking[i] = true;
                    colTracking[j] = true;
                }
            }
        }

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(rowTracking[i] || colTracking[j]){
                    matrix[i][j]= 0;
                }
            }
        }
    }*/
//optimised with O(1) space
    public void setZeroes(int[][] matrix) {
        if(matrix == null)
            return ;
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean firstRow=false,firstColumn=false;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                //checking if firstRow to be zero
                if(i==0){
                    if(matrix[i][j] == 0){
                        firstRow=true;
                    }
                }

                //checking if firstColumns to be zero
                if(j==0){
                    if(matrix[i][j] == 0){
                        firstColumn =true;
                    }
                }
                //making header of row and column zero whenever we encounter 0 positioned
                 if(matrix[i][j] == 0){
                       matrix[i][0] = 0;
                       matrix[0][j] = 0;
                }

            }
        }

        for(int i=1; i<rows; i++){
            for(int j=1; j<cols; j++){
                if(matrix[i][0] ==0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        if(firstRow){
            for(int j=0; j<cols; j++){
                matrix[0][j] = 0;
            }
        }

        if(firstColumn){
            for(int i=0; i<rows ; i++){
                matrix[i][0] = 0;
            }
        }
    }
}