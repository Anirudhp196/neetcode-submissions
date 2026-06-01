class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> frequencies = new HashMap();
        for(Character c: s.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        for(Character c: t.toCharArray()) {
            if(!frequencies.containsKey(c)) {
                return false;
            } else{
                frequencies.put(c, frequencies.get(c) - 1);
            }
        }
        for(Character letter: frequencies.keySet()) {
            if(frequencies.get(letter) != 0) {
                return false;
            }
        }
        return true;
    }
}
