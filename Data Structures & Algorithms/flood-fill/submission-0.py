class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        startColor = image[sr][sc]
        if startColor == color:
            return image
        return self.dfs(image, sr, sc, startColor, color)

    def dfs(self, image, row, col, startColor, color):
        if row < 0 or col < 0 or row >= len(image) or col >= len(image[0]) or image[row][col] != startColor:
            return
        image[row][col] = color
        self.dfs(image, row + 1, col, startColor, color)
        self.dfs(image, row - 1, col, startColor, color)
        self.dfs(image, row, col + 1, startColor, color)
        self.dfs(image, row, col - 1, startColor, color)

        return image