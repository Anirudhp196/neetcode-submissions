public class TrieNode {
    HashMap<Character, TrieNode> trie = new HashMap<>();
    boolean endOfWord;
}

class PrefixTree {

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.trie.get(c) == null) {
                curr.trie.put(c, new TrieNode());
            }
            curr = curr.trie.get(c);
        }
        curr.endOfWord = true;
    }
    
    public boolean search(String word) {
        if(word == null) {
            return false;
        }
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.trie.get(c) == null) {
                return false;
            }
            curr = curr.trie.get(c);
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        if(search(prefix)) {return true;}
        if(prefix == null) {return false;}
        TrieNode curr = root;
        for(char c: prefix.toCharArray()) {
            if(curr.trie.get(c) == null) {
                return false;
            }
            curr = curr.trie.get(c);
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