class WordDictionary {

    public class TrieNode {
        private TrieNode[] children;
        private boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
            isWord = false;
        }
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()) {
            if(curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode curr) {
        //Base Case
        if(index == word.length()) {
            return curr.isWord;
        }
        char c = word.charAt(index);
        if(c == '.') {
            for(TrieNode child: curr.children) {
                if(child != null && dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        TrieNode child = curr.children[c - 'a'];
        if(child == null) {
            return false;
        }
        return dfs(word, index + 1, child);
    }
}
