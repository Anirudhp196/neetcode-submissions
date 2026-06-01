class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String s: tokens) {
            int a = 0; int b = 0;
            if(s.equals("+")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(a + b);
            } else if(s.equals("-")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b - a);
            } else if(s.equals("*")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(a * b);
            } else if(s.equals("/")) {
                a = stack.pop();
                b = stack.pop();
                stack.push(b/a);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.peek();
    }
}
