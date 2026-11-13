class Solution {
    public boolean canJump(int[] nums) {
        //state: dp[i] = can reach i
        //recurrence: dp[i] = true if dp[j] = true && j < i && nums[j] + j >= i
        //start from back- can we reach last from here?
        //dp[n] = true
        
        int target = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= target) {
                target = i;
            }
        }

        return target == 0;
    }
}
