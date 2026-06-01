class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> map1 = new HashMap<>();
        for(char c: s1.toCharArray()) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        int r = s1.length();
        for(int i = 0; i <= s2.length() - r; i++) {
            int currMatches = 0;
            HashMap<Character, Integer> map2 = new HashMap<>();
            for(int j = i; j < i + s1.length(); j++) {
                char c = s2.charAt(j);
                map2.put(c, map2.getOrDefault(c,0) + 1);
                if(map1.getOrDefault(c, 0) < map2.get(c)) {
                    break;
                }
                if(map1.getOrDefault(c, 0) == map2.get(c)) {
                    currMatches++;
                }
            }
            if(currMatches == map1.size()) {
                return true;
            }
        }
        return false;
    }
}
