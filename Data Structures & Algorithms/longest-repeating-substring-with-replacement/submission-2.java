class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0; int l = 0;
        int maxFreq = 0;
        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(c));
            if((r - l + 1) - maxFreq <= k) {
                res = Math.max(res, r-l+1);
            } else {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
        }
        return res;
    }
}
