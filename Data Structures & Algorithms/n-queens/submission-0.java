class Solution {

    List<List<String>> res = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] row: board) {
            Arrays.fill(row, '.');
        }
        backtrack(0, board, n);
        return res;
    }

    private void backtrack(int r, char[][] board, int n) {
        if(r == n) {
            List<String> copy = new ArrayList<>();
            for(char[] row: board) {
                copy.add(new String(row));
            }
            res.add(copy);
            return;
        }

        for(int c = 0; c < n; c++) {
            if(cols.contains(c) || posDiag.contains(r + c) || negDiag.contains(r-c)) {
                continue;
            }
            cols.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            backtrack(r + 1, board, n);

            cols.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }
    }
}
