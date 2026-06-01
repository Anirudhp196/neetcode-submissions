class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (arr1, arr2) -> 
        Integer.compare(arr1[0], arr2[0]));

        ArrayList<int[]> r = new ArrayList<>();
        
        for(int[] interval: intervals) {
            while(r.isEmpty() || r.get(r.size() - 1)[1] < interval[0]) {
                r.add(interval);
            }
            if(r.get(r.size() - 1)[1] >= interval[0]) {
                int max = Math.max(r.get(r.size() - 1)[1], interval[1]);
                r.get(r.size() - 1)[1] = max;
            }
        }

        return r.toArray(new int[0][]);
    }
}
