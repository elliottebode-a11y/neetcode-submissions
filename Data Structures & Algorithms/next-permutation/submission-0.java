class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }
    
    public void nextPermutation(int[] nums) {
        //find first element smaller than right neighbor
        //find smallest element to the right and swap
        //reverse everything to right of swap

        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) break;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            for (; j >= 0; j--) {
                if (nums[j] > nums[i]) break;
            }
            swap(nums, i, j);
        }

        int l = i + 1;
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l++, r--);
        }

    }
}