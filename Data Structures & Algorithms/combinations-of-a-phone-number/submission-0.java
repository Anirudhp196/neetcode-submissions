class Solution {
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return new ArrayList<>();
        }
        String[] numToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        recurse(numToChar, "", 0, digits);
        return res;
    }

    private void recurse(String[] numToChar, String curr, int index, String digits) {
        if(curr.length() == digits.length()) {
            res.add(curr);
            return;
        }
        String chars = numToChar[digits.charAt(index) - '0'];
        for(char c: chars.toCharArray()) {
            recurse(numToChar, curr + c, index+1, digits);
        }
    }
}
