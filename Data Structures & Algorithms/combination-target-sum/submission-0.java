class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        List<Integer> candidate = new ArrayList<>();
        dfs(candidate, target, nums, 0, 0);
        return res;
    }

    private void dfs(List<Integer> candidate, int target, int[] nums, int cur, int index) {
        if(cur == target) {
            res.add(new ArrayList<Integer>(candidate));
            return; //Could we use break here?
        }

        for(int i = index; i < nums.length; i++) {
            candidate.add(nums[i]);
            if(cur + nums[i] <= target) {
                dfs(candidate, target, nums, cur + nums[i], i);
            }
            candidate.remove(candidate.size() - 1);
        }
    }
}
