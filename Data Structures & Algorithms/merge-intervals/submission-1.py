class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:

        """
        intervals = [[1,3], [1, 5], [6, 7]]

        """
        res = []
        intervals.sort()
        for start, end in intervals:
            if res and res[-1][1] >= start:
                maxEnd = max(res[-1][1], end)
                res[-1] = [res[-1][0], maxEnd]
            else:
                res.append([start, end])

        return res