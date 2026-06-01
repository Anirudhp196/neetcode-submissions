class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length + nums2.length];
        int length = res.length;

        int a1 = 0; int a2 = 0; 
        while(a1 < nums1.length && a2 < nums2.length) {
            if(nums1[a1] < nums2[a2]) {
                res[a1 + a2] = nums1[a1];
                a1++;
            } else{
                res[a1 + a2] = nums2[a2];
                a2++;
            }
        }
        while (a1 < nums1.length) {
            res[a1 + a2] = nums1[a1];
            a1++;
        }

        while (a2 < nums2.length) {
            res[a1 + a2] = nums2[a2];
            a2++;
        }

        if(length % 2 == 0) {
            return (res[length / 2 - 1] + res[length / 2]) /2.0;
        } else {
            return res[length / 2];
        }
    }
}
