class Solution:
    def countComponents(self, n: int, edges: List[List[int]]) -> int:
        adjList = defaultdict(list)
        for src, dst in edges:
            adjList[src].append(dst)
            adjList[dst].append(src)
        visit = [False] * n
        num = 0

        bfs = deque()

        for i in range(n):
            if not visit[i]:
                num += 1
                bfs.append(i)
                visit[i] = True
                while bfs:
                    curr = bfs.popleft()
                    for nei in adjList[curr]:
                        if not visit[nei]:
                            visit[nei] = True
                            bfs.append(nei)
                
        return num