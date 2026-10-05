class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        adjList = defaultdict(list) ## Each node has [()] with (B1, nextVal)

        for i, eq in enumerate(equations):
            a, b = eq
            adjList[a].append((b, values[i]))
            adjList[b].append((a, 1 / values[i]))

        res = []

        def bfs(src, tgt):
            if src not in adjList or tgt not in adjList:
                return -1
            bfs = deque([(src, 1)])
            visited = set()

            while bfs:
                node, currWeight = bfs.popleft()
                if node == tgt:
                    return currWeight
                for nei, weight in adjList[node]:
                    if nei not in visited:
                        visited.add(nei)
                        bfs.append((nei, currWeight * weight))
            
            return -1

        for query in queries:
            res.append(bfs(query[0], query[1]))

        return res
            
            
