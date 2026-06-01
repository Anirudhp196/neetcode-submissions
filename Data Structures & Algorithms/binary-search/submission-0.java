class Solution {

    public int binarySearch(int startPoint, int endPoint, int target, int[] nums) {
        if(startPoint > endPoint) {
            return -1;
        }
        int mid = startPoint + (endPoint - startPoint)/2;
        if(nums[mid] < target) {
            return binarySearch(mid+1, endPoint, target, nums);
        } else if(nums[mid] > target) {
            return binarySearch(startPoint, mid-1, target, nums);
        } else{
            return mid;
        }
    }

    public int search(int[] nums, int target) {
        return binarySearch(0, nums.length -1, target, nums);
    }
}
