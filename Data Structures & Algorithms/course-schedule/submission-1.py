class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        inDegrees = [0] * numCourses
        adjList = [[] for i in range(numCourses)]

        for src, dst in prerequisites:
            inDegrees[dst] += 1
            adjList[src].append(dst)
        
        q = deque()
        for n in range(numCourses):
            if inDegrees[n] == 0:
                q.append(n)

        count = 0
        while q:
            curr = q.popleft()
            count += 1
            for nei in adjList[curr]:
                inDegrees[nei] -= 1
                if inDegrees[nei] == 0:
                    q.append(nei)
        
        return count == numCourses
