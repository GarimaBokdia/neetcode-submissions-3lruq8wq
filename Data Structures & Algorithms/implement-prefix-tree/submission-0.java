class TrieNode{
    //R link to children nodes
    private TrieNode[] children;
    private final int R = 26;
    private boolean isWord;
    
    public TrieNode(){
        children = new TrieNode[R];        
    }
    
    public boolean containsKey(char ch){
        return this.children[ch-'a']!=null;
    }
    
    public TrieNode get(char ch){
        return this.children[ch-'a'];
    }
    
    public void put(char ch, TrieNode node){
        this.children[ch-'a'] = node;
    }
    
    public void setWord(){
        this.isWord=true;
    }
    
    public boolean isWord(){
        return isWord;
    }
}

class PrefixTree {
    
    private TrieNode root;

    public PrefixTree() {
        root= new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        //O(M) - M is length of the word
        for(char curr : word.toCharArray()){
            if(!node.containsKey(curr)){
                node.put(curr, new TrieNode());
            }
            node = node.get(curr);
        }
        node.setWord();
    }
    
    public boolean search(String word) {
      
        //using the common function created for finding the match with prefix   
       TrieNode node = searchPrefix(word);
        return node!=null && node.isWord(); //we are finding complete word here so ensure to chekc the word is completeing at this end
    }
    
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        
        for(char curr : word.toCharArray()){
            if(node.containsKey(curr)){
                node = node.get(curr);
            }else{
                return null;
            }
        }   
        
        return node;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */