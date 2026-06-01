class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();

        for(int i = 0; i < n; i++) {
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[1]) {
                int[] pair = stack.pop();
                res[pair[0]] = i - pair[0];
            }
            stack.push(new int[]{i, t});
        }
        return res;
    }
}
