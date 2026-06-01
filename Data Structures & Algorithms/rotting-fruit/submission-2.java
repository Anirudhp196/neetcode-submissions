class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> bfs = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    fresh++;
                }
                if(grid[i][j] == 2) {
                    bfs.add(new int[] {i, j});
                }
            }
        }

        if (bfs.isEmpty()) {
            return fresh == 0 ? 0 : -1;
        }

        int[][] dirs = { {-1,0}, {0,-1}, {1,0}, {0,1} };
        int res = 0;
        while(!bfs.isEmpty()) {
            int size = bfs.size();
            boolean rotted = false;
            for(int i = 0; i < size; i++) {
                int[] node = bfs.poll();
                int row = node[0]; int col = node[1];
                for(int[] dir: dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];

                    if(r < 0 || r >= rows || c < 0 || c >= cols || grid[r][c] != 1) {
                        continue;
                    }
                    if(grid[r][c] == 1) {
                        fresh--;
                        rotted = true;
                    }

                    bfs.add(new int[] {r,c});

                    grid[r][c] = 2;
                }
            }
            if(rotted) {
                res++;
            }
        }

        if(fresh > 0) {
            return -1;
        }
        
        return res;
    }
}
