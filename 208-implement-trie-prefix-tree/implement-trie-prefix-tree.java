
class Trie {

    private static class TrieNode {
        final TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (node.children[i] == null)
                node.children[i] = new TrieNode();
            node = node.children[i];
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

        for (char ch : str.toCharArray()) {
            int i = ch - 'a';
            
            if (node.children[i] == null)
                return null;
            node = node.children[i];
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