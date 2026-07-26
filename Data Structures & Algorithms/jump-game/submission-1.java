class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                return false;
            }

            int distance = nums[i];
            int farthestToReach = i + distance;

            farthest = Math.max(farthest, farthestToReach);

            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}