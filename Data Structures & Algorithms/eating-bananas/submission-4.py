class Solution:
    def minEatingSpeed(self, piles: list[int], h: int) -> int:
        maxPile = 0
        for pile in piles:
            maxPile = max(maxPile, pile)

        l, r = 1, maxPile
        while l < r:
            mid = (l + r) // 2
            hours = 0
            for pile in piles:
                hours += math.ceil(pile / mid)
            if hours <= h:
                r = mid
            else:
                l = mid + 1
        
        return l


