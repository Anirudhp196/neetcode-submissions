class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = [0] * 26
        for task in tasks:
            freq[ord(task) - ord('A')] += 1
        
        maxHeap = []
        
        for val in freq:
            if val > 0:
                heapq.heappush(maxHeap, -val)

        cooldown = deque()
        time = 0
        while maxHeap or cooldown:
            time += 1
            if maxHeap:
                curr = 1 + heapq.heappop(maxHeap)
                if curr < 0:
                    cooldown.append((curr, time + n))
            
            if cooldown and cooldown[0][1] == time:
                heapq.heappush(maxHeap, cooldown.popleft()[0])
        
        return time

def testSol():
    s = Solution()
    tasks = ["X","X","Y","Y"]

    assert s.leastInterval(tasks, 2) == 5
    assert s.leastInterval(["A","A","A","B","C"], 3) == 9
    assert s.leastInterval(["A","A","A"], 0) == 3   

testSol()

