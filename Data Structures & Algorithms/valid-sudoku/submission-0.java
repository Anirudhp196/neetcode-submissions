class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();
        for(int row = 0; row < board.length; row++) {
            for(int col = 0; col < board[0].length; col++) {
                char elt = board[row][col];
                if(elt != '.') {
                    if(set.contains(elt)) {
                        return false;
                    } else{
                        set.add(elt);
                    }
                }
            }
            set.clear();
        }

        for(int col = 0; col < board.length; col++) {
            for(int row = 0; row < board[0].length; row++) {
                char elt = board[row][col];
                if(elt != '.') {
                    if(set.contains(elt)) {
                        return false;
                    } else{
                        set.add(elt);
                    }
                }
            }
            set.clear();
        }

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int rowStart = i * 3;
                int colStart = j * 3;
                for(int row = 0; row < 3; row++) {
                    for(int col = 0; col < 3; col++) {
                        char elt = board[rowStart + row][colStart + col];
                        if(elt != '.') {
                            if(set.contains(elt)) {
                                return false;
                            } else{
                                set.add(elt);
                            }
                        }
                    }
                }
                set.clear();
            }
        }

        return true;
    }
}
