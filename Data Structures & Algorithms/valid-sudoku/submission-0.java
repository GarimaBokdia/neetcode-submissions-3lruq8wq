class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Set<String> valuesSet = new HashSet<>();

        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9 ;col++){
                int currVal = board[row][col];
                if(currVal != '.'){
                        int box = (row/3)*3 + (col/3);
                        String rowWise = currVal+"row"+row;
                        String colWise = currVal+"col"+col;
                        String boxWise = currVal+"box"+box;
                        if(valuesSet.contains(rowWise)
                        || valuesSet.contains(colWise)
                        || valuesSet.contains(boxWise)) 
                        {
                                return false;
                        }

                    valuesSet.add(rowWise);
                    valuesSet.add(colWise);
                    valuesSet.add(boxWise);

                }
            }
        }

        return true;
    }
}
