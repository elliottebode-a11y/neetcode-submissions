class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        //bottom up
        int min2 = nums[0];
        int min1 = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int tmp = Math.max(min2 + nums[i], min1);
            min2 = min1;
            min1 = tmp;
        }
        return Math.max(min1, min2);
    }
}
