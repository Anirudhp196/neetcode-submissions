class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        words = set(wordList)
        if endWord not in words:
            return 0
        visited = set([beginWord])
        bfs = deque([beginWord])

        count = 1

        while bfs:
            currLevel = len(bfs)
            for i in range(currLevel):
                curr = bfs.popleft()
                for nei in self.findNeighbors(words, curr):
                    if nei == endWord:
                        return count + 1
                    if nei not in visited:
                        bfs.append(nei)
                        visited.add(nei)
            count += 1
        
        return 0
            
    def findNeighbors(self, words, currWord):
        neighbors = []
        for i in range(len(currWord)):
            for j in range(ord('a'), ord('z') + 1):
                newWord = currWord[:i] + chr(j) + currWord[i + 1:]
                if newWord in words and newWord != currWord:
                    neighbors.append(newWord)

        return neighbors
        
        