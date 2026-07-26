class Solution {

    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        // Search the left and right borders.
        for (int row = 0; row < rows; row++) {
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }

            if (board[row][columns - 1] == 'O') {
                dfs(board, row, columns - 1);
            }
        }

        // Search the top and bottom borders.
        for (int column = 0; column < columns; column++) {
            if (board[0][column] == 'O') {
                dfs(board, 0, column);
            }

            if (board[rows - 1][column] == 'O') {
                dfs(board, rows - 1, column);
            }
        }

        // Flip surrounded regions and restore safe cells.
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 'O') {
                    // This O was not connected to the border.
                    board[row][column] = 'X';
                } else if (board[row][column] == 'S') {
                    // This cell was connected to the border.
                    board[row][column] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int row, int column) {
        // Stop if outside the board.
        if (row < 0
                || column < 0
                || row >= board.length
                || column >= board[0].length) {
            return;
        }

        // Only continue through unvisited O cells.
        if (board[row][column] != 'O') {
            return;
        }

        // Mark this O as safe.
        board[row][column] = 'S';

        // Search all four adjacent cells.
        dfs(board, row - 1, column);
        dfs(board, row + 1, column);
        dfs(board, row, column - 1);
        dfs(board, row, column + 1);
    }
}