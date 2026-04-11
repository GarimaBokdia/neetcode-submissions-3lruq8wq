class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null)
            return new ArrayList<>();

            int rows = matrix.length;
            int cols = matrix[0].length;
            
        int left=0,right=cols-1,top=0,bottom=rows-1;
        int total = rows * cols ;
        List<Integer> result = new ArrayList<Integer>();
        while(result.size() < total){
            for(int c=left; c<= right && result.size() < total; c++){
                result.add(matrix[top][c]);
            }
            top++;
            for(int r=top; r <= bottom && result.size() < total; r++){
                result.add(matrix[r][right]);
            }
            right--;
            for(int c=right; c>=left && result.size() < total; c--){
                result.add(matrix[bottom][c]);
            }
            bottom--;
            for(int r=bottom;r>=top && result.size() < total; r--){
                result.add(matrix[r][left]);
            }
            left++;
        }

        return result;
    }
}