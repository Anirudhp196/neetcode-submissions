class Solution:
    def networkDelayTime(self, times: list[list[int]], n: int, k: int) -> int:
        travelTimes = [float('inf')] * (n + 1)
        travelTimes[k] = 0
        minHeap = [(0, k)]

        adjList = defaultdict(list)

        for src, dst, time in times:
            adjList[src].append((dst, time))
        
        while minHeap:
            currDist, currNode = heapq.heappop(minHeap)
            if currDist > travelTimes[currNode]:
                continue
            for nei, time in adjList[currNode]:
                newDist = currDist + time
                if newDist < travelTimes[nei]:
                    travelTimes[nei] = newDist
                    heapq.heappush(minHeap, (newDist, nei))

        res = 0
        for time in travelTimes[1:]:
            if time == float('inf'):
                return -1
            if time > res:
                res = time
        
        return res


        
