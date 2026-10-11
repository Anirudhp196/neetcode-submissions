class Solution:
    def maxAreaOfIsland(self, grid: list[list[int]]) -> int:
        res = 0
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    res = max(res, self.dfs(grid, i, j))

        return res

    def dfs(self, grid, i, j):
        res = 1
        if i < 0 or j < 0 or i >= len(grid) or j >= len(grid[0]) or grid[i][j] == 0:
            return 0
        grid[i][j] = 0
        res += self.dfs(grid, i + 1, j)
        res += self.dfs(grid, i - 1, j)
        res += self.dfs(grid, i, j + 1)
        res += self.dfs(grid, i, j - 1)

        return res
