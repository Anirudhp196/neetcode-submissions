class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        res = []
        candidates.sort()

        def dfs(index, currPath, currScore):
            if currScore == target:
                res.append(currPath.copy())
                return
            if currScore > target:
                return
            for i in range(index, len(candidates)):
                if i > index and candidates[i] == candidates[i - 1]:
                    continue
                currPath.append(candidates[i])
                dfs(i + 1, currPath, currScore + candidates[i])
                currPath.pop()

        dfs(0, [], 0)
        return res