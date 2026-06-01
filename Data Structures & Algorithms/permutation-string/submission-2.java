class Solution {
    public boolean checkInclusion(String s1, String s2) {
        char[] hash1 = new char[26];
        for(char c: s1.toCharArray()) { //Hash first string
            hash1[c - 'a']++;
        }
        int l = 0;
        char[] hash2 = new char[26];
        for(int r = 0; r < s2.length(); r++) {
            hash2[s2.charAt(r) - 'a']++;
            if((r - l + 1) > s1.length()) {
                hash2[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(hash1, hash2)){
                return true;
            }
        }
        return false;
    }
}
