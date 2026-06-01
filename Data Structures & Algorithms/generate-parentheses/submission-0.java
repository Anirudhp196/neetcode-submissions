class Solution {
    public List<String> generateParenthesis(int n) {
        // First parenthesis has to be opening, can only add up to n opening and n closing parenthesis
        // Can only add closing parenthesis is #opening > #closing
        List<String> output = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, output, stack);
        return output;
    }
    private void backtrack(int openN, int closedN, int n, List<String> output, StringBuilder stack) {
        if(openN == closedN && openN == n) {
            output.add(stack.toString());
            return;
        }
        if(openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, output, stack);
            stack.deleteCharAt(stack.length()-1);
        }
        if(closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, output, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
