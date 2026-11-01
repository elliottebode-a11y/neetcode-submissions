class Solution {
    public int search(int[] nums, int target) {
        return binSearch(nums, target, 0, nums.length - 1);
    }

    public int binSearch(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        //process- check the middle of the range
        int mid = l + (r - l) / 2;
        if (nums[mid] == target) return mid;
        if (nums[mid] < target) {
            return binSearch(nums, target, mid + 1, r);
        }
        return binSearch(nums, target, l, mid - 1);
    }
}
