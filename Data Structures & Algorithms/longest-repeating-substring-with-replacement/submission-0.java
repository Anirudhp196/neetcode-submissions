class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFrequency = 0; int l = 0;
        int output = 0;
        for(int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
            maxFrequency = Math.max(maxFrequency, map.get(s.charAt(i)));

            while((i-l+1) - maxFrequency > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            output = Math.max(output, i-l+1);
        }
        return output;
    }
}
