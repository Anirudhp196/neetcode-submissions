class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < temperatures.length; i++) {
            int t = temperatures[i];
            while(!stack.isEmpty() && t > stack.peek()[1]) {
                int[] pair = stack.pop();
                answer[pair[0]] = i - pair[0];
            } 
            stack.push(new int[]{i, t});
        }
        return answer;
    }
}
