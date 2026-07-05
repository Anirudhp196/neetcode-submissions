class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMin = 1; int curMax = 1;

        for(int num: nums) {
            int tmp = curMax * num;
            curMax = Math.max(Math.max(curMin * num, curMax * num), num);
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
