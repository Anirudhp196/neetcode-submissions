class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int next = target - nums[i];
            if(map.containsKey(next) && map.get(next) != i) {
                return new int[]{i, map.get(next)};
            }
        }
        return null;
    }
}
