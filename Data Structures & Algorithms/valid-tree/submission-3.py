class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        adjList = defaultdict(list)
        for a, b in edges:
            adjList[a].append(b)
            adjList[b].append(a)
        
        visit = set()

        def dfs(currNode, parent):
            if currNode in visit:
                return False
            visit.add(currNode)
            for nei in adjList[currNode]:
                if nei == parent:
                    continue
                if not dfs(nei, currNode):
                    return False
            return True


        return dfs(0, -1) and len(visit) == n
