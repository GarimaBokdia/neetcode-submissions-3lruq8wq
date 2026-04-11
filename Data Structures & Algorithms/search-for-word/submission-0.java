class Solution {
      char[][] board;
    public boolean exist(char[][] board, String word) {
        if(board == null || word == null)
            return false;
        this.board = board;
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                if (searchWord(r,c,word,0)){
                    return true;
                }
            }
        }

        return false;
    }

    private static final int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    private boolean searchWord(int row,int col, String word, int strIndex){
        if(strIndex == word.length()){
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(strIndex)){
            return false;
        }

        char current = board[row][col];
        board[row][col] = '#';
        for(int[] dir : dirs){
            int r = row + dir[0];
            int c = col + dir[1];
            if(searchWord(r,c,word,strIndex+1)){
                return true;
            }
                
        }
        board[row][col] = current;


        return false;
    }
}
