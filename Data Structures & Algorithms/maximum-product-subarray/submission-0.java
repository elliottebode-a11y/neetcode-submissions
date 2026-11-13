class Solution {
    public int maxProduct(int[] nums) {
        int[] minDp = new int[nums.length];
        int[] maxDp = new int[nums.length];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        //recurrence- nums[i] * minDp, maxDp max/ min

        for (int i = 1; i < nums.length; i++) {
            minDp[i] = Math.min(nums[i], Math.min(nums[i] * minDp[i - 1], nums[i] * maxDp[i - 1]));
            maxDp[i] = Math.max(nums[i], Math.max(nums[i] * minDp[i - 1], nums[i] * maxDp[i - 1]));
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = maxDp[i] > max ? maxDp[i] : max;
        }
        return max;
    }
}
