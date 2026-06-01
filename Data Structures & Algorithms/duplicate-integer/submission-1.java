class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> frequencies = new HashSet<>();

        for(int num: nums) {
            if(frequencies.contains(num)) {
                return true;
            } else{
                frequencies.add(num);
            }
        }
        return false;
    }
}
