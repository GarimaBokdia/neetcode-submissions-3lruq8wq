class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null )
        return ;

        //transpose the matrix i.e. covert rowxs to columns and then reverse each row

        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int r=0 ; r <rows; r++){
            for(int c=r; c<cols; c++){//initiate c from r to avoid swapping the already swapperd items
               int temp = matrix[r][c];
               matrix[r][c] = matrix[c][r];
                      matrix[c][r] = temp;          
    
            }
        }

        //revering the rows        
        for(int r=0; r<rows; r++){
           reverse(matrix,r);
        }
    }



    public static void reverse(int[][] matrix,int row){
        int left=0, right = matrix[row].length-1;
        while(left<right){
            int temp = matrix[row][left];
            matrix[row][left] = matrix[row][right];
            matrix[row][right] = temp;
            left++;
             right--;  
        }
    }
}