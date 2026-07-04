class Solution {
    public int countSubstrings(String s) {
        int ans = 0;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            dp[i][i] = true;
            ans++;
        }

        for(int len = 2; len <= n; len++) {
            for(int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                if(s.charAt(i) == s.charAt(j)) {
                    if(len <= 2 || dp[i+1][j-1]) {
                        dp[i][j] = true;
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}
