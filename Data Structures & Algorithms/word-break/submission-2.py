class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        ## dp[i] is True if s[0:i] forms a word
        words = set(wordDict)
        n = len(s)
        dp = [False] * (n + 1) 
        dp[0] = True
        for i in range(1, n + 1):
            for j in range(0, i):
                if dp[j] and s[j:i] in words:
                    dp[i] = True
                    break
        
        return dp[n]