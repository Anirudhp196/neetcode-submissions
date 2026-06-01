class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {
        List<String> curr = new ArrayList<>();
        recurse(s, 0, curr);
        return res;
    }

    private void recurse(String s, int index, List<String> curr) {
        if(index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i+1));
                recurse(s, i+1, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }


}
