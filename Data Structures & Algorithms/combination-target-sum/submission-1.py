class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []

        def dfs(start, currPath, currScore):
            if currScore == target:
                res.append(currPath.copy())
                return
            if currScore > target:
                return
            for i in range(start, len(nums)):
                currPath.append(nums[i])
                dfs(i, currPath, currScore + nums[i])
                currPath.pop()
                
        dfs(0, [], 0)
        return res