class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                if(recurse(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean recurse(char[][] board, String word, int r, int c, int index) {
        if(index == word.length()) {
            return true;
        }
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length || 
        board[r][c] != word.charAt(index) || board[r][c] == '#') {
            return false;
        }
        board[r][c] = '#';
        boolean res = recurse(board, word, r-1, c, index + 1) ||
            recurse(board, word, r+1, c, index+1) ||
            recurse(board, word, r, c-1, index+1) ||
            recurse(board, word, r, c+1, index+1);
        board[r][c] = word.charAt(index);
        return res;
    }
}