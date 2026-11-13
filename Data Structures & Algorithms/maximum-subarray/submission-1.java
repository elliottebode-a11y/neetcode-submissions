class Solution {
    public int maxSubArray(int[] nums) {
        //choice- start new or end 
        int max = nums[0];
        int tmp = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
            max = Math.max(max, tmp);
        }
        return max;
    }
}
