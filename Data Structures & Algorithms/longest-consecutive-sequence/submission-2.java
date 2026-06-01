class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }

        int res = 0;
        int counter = 0;
        for(int num: nums) {
            int curr = num;
            while(set.contains(curr)) {
                counter++;
                res = Math.max(res, counter);
                curr++;
            }
            counter = 0;
        }

        return res;
    }
}
