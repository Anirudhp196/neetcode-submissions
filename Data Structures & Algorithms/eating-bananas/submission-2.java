class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int min = 1;
        int max = Integer.MIN_VALUE;
        for(int pile: piles) {
            max = Math.max(max, pile);
        }
        int output = max;
        while(min <= max) {
            int mid = min + (max-min)/2;
            int totalTime = 0;
            for(int pile: piles) {
                totalTime += Math.ceil((double) pile / mid);
            }
            if(totalTime <= h) {
                output = mid;
                max = mid-1;
            } else {
                min = mid+1;
            }
        }
        return output;
    }
}
