class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        elts = set()
        for num in nums:
            elts.add(num)
        
        res = 0
        for num in elts:
            if num - 1 not in elts:
                curr = 1
                while num + 1 in elts:
                    curr += 1
                    num += 1
                res = max(res, curr)
        
        return res