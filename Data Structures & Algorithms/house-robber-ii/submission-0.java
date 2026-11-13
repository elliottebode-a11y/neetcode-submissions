class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[1], nums[0]);
        int with1 = robHelp(nums, 0, nums.length - 1);
        int without1 = robHelp(nums, 1, nums.length);
        return Math.max(with1, without1);
    }

    public int robHelp(int[] nums, int st, int end) {
        int min2 = nums[st];
        int min1 = Math.max(nums[st], nums[st + 1]);

        for (int i = st + 2; i < end; i++) {
            int tmp = Math.max(nums[i] + min2, min1);
            min2 = min1;
            min1 = tmp;
        }
        
        return min1;
    }
}
