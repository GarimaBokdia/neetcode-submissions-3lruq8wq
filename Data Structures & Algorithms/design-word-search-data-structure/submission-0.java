class WordDictionary {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        TrieNode(){
            children=new TrieNode[26];
        }
    }
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index]==null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord  = true;
    }
    
    public boolean search(String word) {
        return searchInTrie(root,0,word);
    }

    private boolean searchInTrie(TrieNode node,int wordIndex,String word){
            if(wordIndex == word.length()){
                return node.isWord;
            }
            char ch = word.charAt(wordIndex);
            if( ch == '.'){
                for(int i=0; i<26; i++){
                    //checking for all the combinations from each character
                    if(node.children[i] != null){
                        if(searchInTrie(node.children[i],wordIndex+1,word))
                            return true;
                    }           
                }
                return false;
            }else{
                int idx = ch - 'a';
                if(node.children[idx]== null){
                    return false;
                }
                return searchInTrie(node.children[idx],wordIndex+1,word);
            }
        }
   
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */