class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        res = [1] * n
        prefix = [1] * n
        curr = 1
        for i in range(n):
            prefix[i] = curr
            curr *= nums[i]

        suffix = [1] * n
        curr = 1
        for i in range(n - 1, -1, -1):
            suffix[i] = curr
            curr *= nums[i]

        for i in range(n):
            res[i] = prefix[i] * suffix[i]
            
        return res

        

        

        