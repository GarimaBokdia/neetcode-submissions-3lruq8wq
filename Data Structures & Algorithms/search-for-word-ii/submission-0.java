class Solution {
    class TrieNode{
        TrieNode[] children;
        String endWord;
        TrieNode(){
            children = new TrieNode[26];
            endWord=null;
        }
    }
    
    List<String> result;
    int[][] dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    char[][] board;
    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String word : words)
        {
            TrieNode curr = root;
            for(char ch : word.toCharArray())
            {
                if(curr.children[ch-'a']==null){
                    curr.children[ch-'a']=new TrieNode();
                }
                curr = curr.children[ch-'a'];
            }
            curr.endWord = word;
        }
        return root;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        //Build the trie for the search words
        TrieNode root = buildTrie(words);
        //now we do DFS traversal of whole board to find the words
        result = new ArrayList<String>();
        
        for(int r=0; r<board.length; r++){
            for(int c=0; c<board[0].length; c++){
                searchWords(root,r,c);
            }
        }        
        
        return result;
    }
    
    private void searchWords(TrieNode node, int row, int col)
    {
        if(row<0 || col<0 || row>=board.length || col >= board[0].length)
            return;
        
        char current= board[row][col];
        if(current=='#') //already considred in current word
            return;
        
        if(node.children[current -'a']==null)
            return;
        
        //found valid word, add to result and set it to null so that it is not considered again
        if(node.children[current -'a'].endWord!=null){
            result.add(node.children[current -'a'].endWord);
            node.children[current -'a'].endWord=null;
        }
       
        //valid character, now check in all the directions
       board[row][col] = '#';
        
        for(int[] dir : dirs){
            int x = row + dir[0];
            int y = col + dir[1];
            searchWords(node.children[current-'a'],x,y);
        }
        
        board[row][col] = current;
    }
    
}