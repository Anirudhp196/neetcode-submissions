import sys
from collections import deque

class Solution:
    def shortestBridge(self, grid: list[list[int]]) -> int:
        n = len(grid)
        firstIsland = deque()
        visited = set()

        def dfs(row, col):
            if row < 0 or row >= n or col < 0 or col >= n or grid[row][col] == 0 or (row, col) in visited:
                return
            firstIsland.append((row, col))
            visited.add((row, col))
            dfs(row + 1, col)
            dfs(row - 1, col)
            dfs(row, col + 1)
            dfs(row, col - 1)

        found = False
        for i in range(n):
            if found:
                break
            for j in range(n):
                if grid[i][j] == 1:
                    dfs(i, j)
                    found = True
                    break

        layer = 0
        dirs = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        while firstIsland:
            for _ in range(len(firstIsland)):
                row, col = firstIsland.popleft()
                for dr, dc in dirs:
                    r, c = row + dr, col + dc
                    if r < 0 or r >= n or c < 0 or c >= n or (r, c) in visited:
                        continue
                    if grid[r][c] == 1:
                        return layer        # touched the second island
                    visited.add((r, c))     # water cell, flip it and expand from it next layer
                    firstIsland.append((r, c))
            layer += 1

        return -1