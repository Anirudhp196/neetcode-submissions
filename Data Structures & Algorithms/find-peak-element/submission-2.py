class Solution:
    def findPeakElement(self, nums: list[int]) -> int:
        n = len(nums)
        l, r = 0, n - 1
        while l < r:
            mid = (l + r + 1) // 2
            if nums[mid] > nums[mid - 1]:
                l = mid
            else:
                r = mid - 1
        
        return l
        

        