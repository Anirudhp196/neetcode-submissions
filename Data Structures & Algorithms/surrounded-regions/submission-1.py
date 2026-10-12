class Solution:
    def solve(self, board: list[list[str]]) -> None:
        m, n = len(board), len(board[0])

        def dfs(r, c):
            if r < 0 or c < 0 or r >= len(board) or c >= len(board[0]) or board[r][c] != "O":
                return
            board[r][c] = 'S'
            dfs(r + 1, c)
            dfs(r - 1, c)
            dfs(r, c + 1)
            dfs(r, c - 1)

        for r in range(m):
            dfs(r, 0)
            dfs(r, n - 1)
        for c in range(n):
            dfs(0, c)
            dfs(m - 1, c)
        
        for i in range(m):
            for j in range(n):
                if board[i][j] == "O":
                    board[i][j] = "X"
                elif board[i][j] == "S":
                    board[i][j] = "O"

        