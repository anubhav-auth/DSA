class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    Boolean isEnd = false;
}

class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;

        for(char ch: word.toCharArray()){
            node = node.children.computeIfAbsent(ch, c -> new TrieNode());
        }

        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = getNode(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return getNode(prefix) != null;
    }

    public TrieNode getNode(String str){
        TrieNode node = root;

        for(char ch: str.toCharArray()){
            node = node.children.get(ch);
            if(node == null) return null;
        }

        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */