class Solution {
    public int maxArea(int[] heights) {
        int outputArea = 0;
        int l = 0; int r = heights.length - 1;
        while(l < r) {
            int area = Math.min(heights[l], heights[r]) * (r-l);
            if(area > outputArea) {
                outputArea = area;
            }
            if(heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return outputArea;
    }
}
