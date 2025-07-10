
class Trie {

    final static class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    final TrieNode root = new TrieNode();

    public Trie() {}

    public void insert(String word) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int j = ch - 'a';
            if (node.children[j] == null)
                node.children[j] = new TrieNode();
            node = node.children[j];
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

    public TrieNode getNode(String str) {
        TrieNode node = root;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int j = ch - 'a';
            
            if (node.children[j] == null)
                return null;
            node = node.children[j];
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