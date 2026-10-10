class Solution:
    def orangesRotting(self, grid: list[list[int]]) -> int:
        bfs = deque()
        n = len(grid)
        m = len(grid[0])

        visited = set()

        freshOranges = 0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 2:
                    bfs.append((i, j))
                elif grid[i][j] == 1:
                    freshOranges += 1

        if freshOranges == 0:
            return 0
        
        time = 0
        dirs = [[-1, 0], [1, 0], [0, -1], [0, 1]]
        while bfs:
            size = len(bfs)
            if freshOranges == 0:
                return time
            time += 1
            for i in range(size):
                row, col = bfs.popleft()
                for dir in dirs:
                    newRow = row + dir[0]
                    newCol = col + dir[1]
                    if newRow < 0 or newRow >= n or newCol < 0 or newCol >= m:
                        continue
                    if grid[newRow][newCol] == 1:
                        bfs.append((newRow, newCol))
                        grid[newRow][newCol] = 2
                        freshOranges -= 1

        return -1