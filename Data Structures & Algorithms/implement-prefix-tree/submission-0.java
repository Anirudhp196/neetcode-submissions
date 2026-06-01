public class TrieNode {
    TrieNode[] children = new TrieNode[26];
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
            int index = c - 'a';
            if(curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.endOfWord = true; 
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        if(word == null) { 
            return false;
        }
        for(char c: word.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return curr.endOfWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        if(prefix == null) {
            return false;
        }
        for(char c: prefix.toCharArray()) {
            int index = c - 'a';
            if(curr.children[index] == null) {
                return false;
            }
            curr = curr.children[index];
        }
        return true;
    }
}