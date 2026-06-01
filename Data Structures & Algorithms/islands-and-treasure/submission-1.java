class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 0) {
                    bfs.add(new int[]{i, j});
                }
            }
        }
        if(bfs.size() == 0) {
            return;
        }

        int[][] dirs = { {-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!bfs.isEmpty()) {
            int[] node = bfs.poll();
            int row = node[0]; int col = node[1];
            for(int[] dir: dirs) {
                int r = row + dir[0];
                int c = col + dir[1];

                if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                bfs.add(new int[]{r, c});

                grid[r][c] = 1 + grid[row][col];
            }

        }

    }
}
