class Solution:
    def longestOnes(self, nums: List[int], k: int) -> int:
        n = len(nums)
        l, r = 0, 1
        currZero = 0
        res = 0
        for r in range(n):
            if nums[r] == 0:
                currZero += 1

            while currZero > k:
                if nums[l] == 0:
                    currZero -= 1
                l += 1
            res = max(res, r - l + 1)
        
        return res

        