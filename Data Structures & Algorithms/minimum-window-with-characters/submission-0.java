class Solution {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) {
            return "";
        }
        Map<Character, Integer> tCount = new HashMap<>();
        for(char c: t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> window = new HashMap<>();
        int have = 0; int need = tCount.size();
        int l = 0;
        int[] res = {-1,-1};
        int resLength = Integer.MAX_VALUE;

        for(int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c,0) + 1);
            if(tCount.containsKey(c) && window.get(c).equals(tCount.get(c))) {
                have++;
            }

            while(have == need) {
                if((r - l + 1) < resLength) {
                    resLength = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }
                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if(tCount.containsKey(leftChar) && window.get(leftChar) < tCount.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }
        if(resLength == Integer.MAX_VALUE) {
            return "";
        } else{
            return s.substring(res[0], res[1] + 1);
        }
    }
}
