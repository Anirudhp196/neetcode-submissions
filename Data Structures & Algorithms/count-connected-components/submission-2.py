class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adjList = defaultdict(list)
        for src, dst in edges:
            adjList[src].append(dst)
            adjList[dst].append(src)
        visit = [False] * n
        num = 0

        def dfs(currNode):
            if visit[currNode]:
                return
            visit[currNode] = True
            for nei in adjList[currNode]:
                dfs(nei)
              
        for i in range(n):
            if not visit[i]:
                num += 1
                dfs(i)

        return num


