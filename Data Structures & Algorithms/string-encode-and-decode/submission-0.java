class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str: strs) {
            res.append(str.length()).append('&').append(str);
        }
        System.out.println(res.toString());
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int startIndex = 0;
        while(startIndex < str.length()) {
            int endIndex = startIndex;
            while(str.charAt(endIndex) != '&') {
                endIndex++;
            }
            int length = Integer.parseInt(str.substring(startIndex, endIndex));
            startIndex = endIndex + 1;
            endIndex = startIndex + length;
            res.add(str.substring(startIndex, endIndex));
            startIndex = endIndex;
        }
        return res;
    }
}
