class Solution {
    private int[][] directions = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;

        boolean[][] pac = new boolean[rows][cols];
        boolean[][] atl = new boolean[rows][cols];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for(int c = 0; c < cols; c++) {
            pacQueue.add(new int[] {0, c});
            atlQueue.add(new int[] {rows - 1, c});
        }

        for(int r = 0; r < rows; r++) {
            pacQueue.add(new int[] {r, 0});
            atlQueue.add(new int[] {r, cols - 1});
        }

        bfs(pacQueue, pac, heights);
        bfs(atlQueue, atl, heights);

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pac[i][j] && atl[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    private void bfs(Queue<int[]> q, boolean[][] ocean, int[][] heights) {
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0]; int c = curr[1];
            ocean[r][c] = true;
            for(int[] dir: directions) {
                int nr = r + dir[0]; int nc = c + dir[1];
                if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !ocean[nr][nc]
                && heights[nr][nc] >= heights[r][c]) {
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}
