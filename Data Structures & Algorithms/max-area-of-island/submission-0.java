class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        int currArea = 1;
        grid[i][j] = 0;
        currArea += dfs(grid, i+1, j);
        currArea += dfs(grid, i-1, j);
        currArea += dfs(grid, i, j+1);
        currArea += dfs(grid, i, j-1);

        return currArea;
    }
}
