class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num: nums) {
            set.add(num);
        }
        int output = 0;
        for(int num: set) {
            if(!set.contains(num-1)) {
                int length = 1;
                while(set.contains(num + length)) {
                    length++;
                }
                output = Math.max(output, length);
            }
        }

        return output;
    }
}
