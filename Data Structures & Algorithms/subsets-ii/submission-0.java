class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(nums);
        dfs(curr, nums, 0);
        return res;
    }

    private void dfs(List<Integer> curr, int[] nums, int index) {
        if(index == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        dfs(curr, nums, index + 1);
        while(index + 1 < nums.length && nums[index] == nums[index+1]) {
            index++;
        }
        curr.remove(curr.size()-1);
        dfs(curr, nums, index + 1);
    }


}
