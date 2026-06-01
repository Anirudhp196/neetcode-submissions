class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, curr, 0, 0);
        return res;
    }

    private void dfs(int[] candidates, int target, List<Integer> curr, int index, int currSum) {
        if(currSum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(currSum > target || index == candidates.length) {
            return;
        }
        curr.add(candidates[index]);
        dfs(candidates, target, curr, index + 1, currSum + candidates[index]);
        curr.remove(curr.size() - 1);
        while(index + 1 < candidates.length && candidates[index] == candidates[index+1]) {
            index++;
        }
        dfs(candidates, target, curr, index + 1, currSum);
    }
}