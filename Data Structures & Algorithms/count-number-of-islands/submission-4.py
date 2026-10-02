class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        res = 0
        for i in range(0, len(grid)):
            for j in range(0, len(grid[0])):
                if grid[i][j] == '1':
                    self.dfs(i, j, grid)
                    res += 1

        return res

    def dfs(self, row, col, grid):
        ## Recursive
        if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or grid[row][col] == '0':
            return
            
        grid[row][col] = '0'
        self.dfs(row + 1, col, grid)
        self.dfs(row - 1, col, grid)
        self.dfs(row, col + 1, grid)
        self.dfs(row, col - 1, grid)
        