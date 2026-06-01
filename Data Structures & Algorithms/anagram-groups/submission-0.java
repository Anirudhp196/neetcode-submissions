class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       Map<String, List<String>> map = new HashMap<>();
        for(String str: strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedChar = new String(strArr);
            map.putIfAbsent(sortedChar, new ArrayList<>());
            map.get(sortedChar).add(str);
        }

        return new ArrayList<> (map.values()); 
    }
}
