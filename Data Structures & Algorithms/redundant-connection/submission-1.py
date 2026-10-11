class Solution:
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        n = len(edges)
        parent = [-1] * (n + 1)
        for i in range(len(parent)):
            parent[i] = i
        print(parent)
        size = [0] * (n + 1)

        def find(x):
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]
        
        for a, b in edges:
            rootA, rootB = find(a), find(b)
            if rootA == rootB:
                return [a,b]
            if size[rootA] < size[rootB]:
                rootA, rootB = rootB, rootA
            parent[rootB] = rootA
            size[rootA] += size[rootB]
        
        return []