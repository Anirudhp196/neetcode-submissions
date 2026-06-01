class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        if(n == 1) {
            return nums[0];
        }

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i < n; i++) {
            if(dp[i-1] > dp[i-2] + nums[i]) {
                dp[i] = dp[i-1];
            } else {
                dp[i] = dp[i-2] + nums[i];
            }
        }

        return Math.max(dp[n-1], dp[n-2]);
    }
}
