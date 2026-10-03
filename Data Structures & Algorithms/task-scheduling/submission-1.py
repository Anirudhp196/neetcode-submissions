class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        res = 0
        freqMap = defaultdict(int)
        for task in tasks:
            freqMap[task] += 1
        maxFreq = max(freqMap.values())

        numMax = 0
        for num in freqMap.values():
            if num == maxFreq:
                numMax += 1

        intervals = (n + 1) * (maxFreq - 1) + numMax

        return max(intervals, len(tasks))
