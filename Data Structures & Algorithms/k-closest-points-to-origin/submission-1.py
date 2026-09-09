class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        res = []
        maxHeap = []
        for x, y in points:
            dist = x * x + y * y
            if len(maxHeap) < k:
                heapq.heappush(maxHeap, (-dist, (x, y)))
            elif len(maxHeap) == k:
                if maxHeap[0][0] < -dist:
                    heapq.heappop(maxHeap)
                    heapq.heappush(maxHeap, (-dist, (x, y)))

        for distance, point in maxHeap:
            res.append(point)

        return res


        