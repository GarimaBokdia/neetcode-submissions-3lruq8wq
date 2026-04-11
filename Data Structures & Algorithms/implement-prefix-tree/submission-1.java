class PrefixTree {
      TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        public TrieNode(){
            children = new TrieNode[26];
            isWord=false;
        }
    }

    public PrefixTree() {
  
        
            root = new TrieNode();
       
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(node.children[index]==null){
                return false;
            }
            node = node.children[index];
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {

        TrieNode node = root;
        for(char ch : prefix.toCharArray()){
            int index = ch - 'a';
            if(node.children[index]==null){
                return false;
            }
            node = node.children[index];
        }
        return true;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */