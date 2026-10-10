class Solution:
    def reorganizeString(self, s: str) -> str:
        
        """
        aaaabbc -> 
        """

        freqMap = defaultdict(int)
        for c in s:
            freqMap[c] += 1
        
        maxFreq = max(freqMap.values())
        if maxFreq > (len(s) + 1) // 2:
            return ""

        maxHeap = []

        for char, val in freqMap.items():
            heapq.heappush(maxHeap, (-val, char))
        
        res = ""

        while maxHeap:
            if len(maxHeap) == 1:
                res += heapq.heappop(maxHeap)[1]
            else:
                num1, maxFreqChar1 = heapq.heappop(maxHeap)
                num2, maxFreqChar2 = heapq.heappop(maxHeap)
                
                res += maxFreqChar1
                res += maxFreqChar2
                if -num1 > 1:
                    heapq.heappush(maxHeap, (num1 + 1, maxFreqChar1))
                if -num2 > 1:
                    heapq.heappush(maxHeap, (num2 + 1, maxFreqChar2))
                
        return res

