class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int c=0, r = rows -1 ;
        //start from bottom left 
        //or top right

        while(c < cols && r >= 0){
            if(matrix[r][c]==target)
                return true;
            else if (matrix[r][c] > target){
                r--;
            }else{
                c++;
            }
        }
        return false;
    }
}