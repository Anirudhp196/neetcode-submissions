class Solution:
    def search(self, nums: list[int], target: int) -> int:

        n = len(nums)
        l, r = 0, n - 1
        start = 0
        while l < r:
            mid = (l + r) // 2
            if nums[mid] > nums[r]:
                l = mid + 1 
            else:
                r = mid

        start = l
        l, r = 0, n - 1

        while(l <= r):
            mid = (l + r) // 2
            real = (mid + start) % n
            if nums[real] == target:
                return real
            elif nums[real] < target:
                l = mid + 1
            else:
                r = mid - 1
        
        return -1
         

        