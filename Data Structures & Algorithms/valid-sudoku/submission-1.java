class Solution {
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            Set<Character> rowSet = new HashSet<>();
            for(int j = 0; j < cols; j++) {
                char cell = board[i][j];
                if(cell != '.') {
                    if(!rowSet.add(cell)) {
                        return false;
                    }
                }
            }
        }

        for(int i = 0; i < cols; i++) {
            Set<Character> colSet = new HashSet<>();
            for(int j = 0; j < rows; j++) {
                char cell = board[j][i];
                if(cell != '.') {
                    if(!colSet.add(cell)) {
                        return false;
                    }
                }
            }
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                Set<Character> squareSet = new HashSet<>();
                for(int row = 0; row < 3; row++) {
                    for(int col = 0; col < 3; col++) {
                        char cell = board[3 * i + row][3 * j + col];
                        if(cell != '.') {
                            if(!squareSet.add(cell)) {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;

    }
}
