class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) {
            sum += num;
        }
        if(sum % 2 == 1) {
            return false;
        }
        int target = sum/2;
        //dp[j] = true if we can form sum j using some of the nums so far
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int i = 0; i < nums.length; i++) {
            for(int j = target; j >= nums[i]; j--) {
                if(!dp[j]) {
                    dp[j] = dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }
}
