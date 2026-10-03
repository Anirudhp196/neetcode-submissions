class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False

        need = [0] * 26
        for c in s1:
            need[ord(c) - ord("a")] += 1
        
        have = [0] * 26
        l = 0
        k = len(s1)
        for r in range(len(s2)):
            have[ord(s2[r]) - ord("a")] += 1
            if r >= k:
                have[ord(s2[r-k]) - ord("a")] -= 1
            if have == need:
                return True
        
        return False


        