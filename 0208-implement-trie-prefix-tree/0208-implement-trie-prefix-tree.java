class TrieNode{
    Map<Character, TrieNode> children = new HashMap();
    boolean isWord = false;
}

class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curNode = root;
        char[] chars = word.toCharArray();
        
        for(char curChar : chars){
            if(!curNode.children.containsKey(curChar)){
                curNode.children.put(curChar, new TrieNode());
            }
            curNode = curNode.children.get(curChar);
        }
        curNode.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curNode = root;
        char[] chars = word.toCharArray();
        
        for(char curChar : chars){
            if(curNode.children.containsKey(curChar) == false){
                return false;
            }
            curNode = curNode.children.get(curChar);
        }
        return curNode.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        char[] chars = prefix.toCharArray();
        
        for(char curChar : chars){
            if(curNode.children.containsKey(curChar) == false){
                return false;
            }
            curNode = curNode.children.get(curChar);
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