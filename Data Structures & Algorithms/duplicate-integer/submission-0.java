class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for(int num: nums) {
            frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        for(int i: frequencies.keySet()) {
            if(frequencies.get(i) > 1) {
                return true;
            }
        }
        return false;
    }
}
