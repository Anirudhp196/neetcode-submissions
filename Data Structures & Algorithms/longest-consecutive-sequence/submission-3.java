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
            counter = 0;
            while(set.contains(curr)) {
                counter++;
                curr++;
            }
            res = Math.max(res, counter);
        }

        return res;
    }
}
