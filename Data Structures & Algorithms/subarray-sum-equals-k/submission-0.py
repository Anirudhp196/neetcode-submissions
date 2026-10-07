class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        map = defaultdict(int)
        map[0] = 1
        prefixSum = 0
        for num in nums:
            prefixSum += num
            if prefixSum - k in map:
                res += map[prefixSum - k]
            map[prefixSum] += 1

        return res

        