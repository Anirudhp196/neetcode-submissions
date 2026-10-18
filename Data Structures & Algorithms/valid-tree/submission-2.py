class Solution:
    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) != n - 1:
            return False
        parents = list(range(n))

        def find(x):
            while parents[x] != x:
                parents[x] = parents[parents[x]]
                x = parents[x]
            return x

        
        for a, b in edges:
            ra, rb = find(a), find(b)
            if ra == rb:
                return False
            parents[ra] = rb
        
        return True