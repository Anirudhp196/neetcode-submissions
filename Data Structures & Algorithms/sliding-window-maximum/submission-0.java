class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[nums.length - k + 1];

        for(int i = 0; i <= n - k; i++) {
            res[i] = nums[i];
            for(int j = i; j < i+k; j++) {
                res[i] = Math.max(res[i], nums[j]);
            }
        }

        return res;
    }
}
