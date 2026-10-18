class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        res = []
        for num in nums:
            realNum = abs(num)
            if nums[realNum - 1] > 0:
                nums[realNum - 1] *= -1
            else:
                res.append(realNum)
        
        return res
