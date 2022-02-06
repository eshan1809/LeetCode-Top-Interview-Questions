class Trie {
    class Node{
        Node[] children;
        boolean isEnd;
        Node(){
            children = new Node[26];
        }
    }
    
    Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node();
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.children[ch - 'a'] == null)
                return false;
            curr = curr.children[ch - 'a'];
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
