class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String s: strs) {
            int[] hash = new int[26];
            for(char c: s.toCharArray()) {
                hash[c - 'a']++;
            }
            String h = Arrays.toString(hash);
            if(!map.containsKey(h)) {
                map.put(h, new ArrayList<>());
            }
            map.get(h).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
