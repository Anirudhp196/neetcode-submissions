class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        boolean[] found = new boolean[nums.length];
        dfs(nums, curr, found);
        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, boolean[] found) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!found[i]) {
                curr.add(nums[i]);
                found[i] = true;
                dfs(nums, curr, found);
                curr.remove(curr.size()-1);
                found[i]= false;
            }
        }
    }
}