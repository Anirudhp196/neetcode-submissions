class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int pile: piles) {
            max = Math.max(pile, max);
        }   
        int res = Integer.MAX_VALUE;
        int l = 1; int r = max;
        while(l <= r) {
            int k = (l + r)/2;
            int counter = 0;
            for(int pile: piles) {
                counter += Math.ceil((double) pile /k);
            }
            if(counter <= h) {
                res = Math.min(res, k);
                r = k - 1;
            } else {
                l = k + 1;
            }
        }

        return res;
    }
}
