class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        return Math.max(robLinear(nums, 0, n-2), robLinear(nums, 1, n-1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int twoBack = 0;
        int oneBack = 0;

        for(int i = start; i <= end; i++) {
            int curr = Math.max(twoBack + nums[i], oneBack);
            twoBack = oneBack;
            oneBack = curr;
        }

        return oneBack;
    }
}
