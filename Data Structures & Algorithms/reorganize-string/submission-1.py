import heapq
from collections import defaultdict

class Solution:
    def reorganizeString(self, s: str) -> str:
        freqMap = defaultdict(int)
        for c in s:
            freqMap[c] += 1

        if max(freqMap.values()) > (len(s) + 1) // 2:
            return ""

        res = ""
        maxHeap = []

        for char, val in freqMap.items():
            heapq.heappush(maxHeap, (-val, char))

        while maxHeap:
            if len(maxHeap) == 1:
                res += heapq.heappop(maxHeap)[1]
            else:
                val1, char1 = heapq.heappop(maxHeap)
                val2, char2 = heapq.heappop(maxHeap)

                res += char1
                res += char2

                if -val1 > 1:
                    heapq.heappush(maxHeap, (val1 + 1, char1))
                if -val2 > 1:
                    heapq.heappush(maxHeap, (val2 + 1, char2))

        return res