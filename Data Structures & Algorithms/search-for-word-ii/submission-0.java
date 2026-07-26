class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[0].length; c++) {
                recurse(board, root, r, c, res);
            }
        }
        return res;
    }

    private void recurse(char[][] board, TrieNode node, int row, int col, List<String> res) {
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length) {
            return;
        }
        char ch = board[row][col];
        if(ch == '#'|| node.children[ch - 'a'] == null) {
            return;
        }
        node = node.children[ch - 'a'];

        if(node.word != null) {
            res.add(node.word);
            node.word = null;
        }

        board[row][col] = '#';
        recurse(board, node, row - 1, col, res);
        recurse(board, node, row + 1, col, res);
        recurse(board, node, row, col-1, res);
        recurse(board, node, row, col + 1, res);
        board[row][col] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for(String word: words) {
            TrieNode node = root;
            for(char ch: word.toCharArray()) {
                int i = ch - 'a';
                if(node.children[i] == null) {
                    node.children[i] = new TrieNode();
                }
                node = node.children[i];
            }
            node.word = word;
        }
        return root;
    }
}