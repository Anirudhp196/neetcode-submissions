class Solution {
    public int largestRectangleArea(int[] heights) {
        int output = 0;
        for(int i = 0; i < heights.length; i++) {
            int currHeight = heights[i];
            int r = i+1;
            while(r < heights.length && heights[r] >= currHeight){
                r++;
            }
            int l = i;
            while(l >= 0 && heights[l] >= currHeight){
                l--;
            }
            r--;
            l++;
            output = Math.max(output, currHeight * (r - l + 1));
        }
        return output;
    }
}
