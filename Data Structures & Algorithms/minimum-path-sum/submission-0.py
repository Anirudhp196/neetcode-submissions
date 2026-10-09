class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])

        dp = [[0] * m for _ in range(n)]

        for i in range(n):
            for j in range(m):
                if i == 0 and j == 0:
                    dp[0][0] = grid[0][0]
                    continue
                upNum = float('inf')
                if i - 1 >= 0:
                    upNum = dp[i - 1][j]
                
                leftNum = float('inf')
                if j - 1 >= 0:
                    leftNum = dp[i][j-1]
                
                dp[i][j] = (min(upNum, leftNum) + grid[i][j])


        return dp[n - 1][m - 1]