class Solution {
    public boolean canJump(int[] nums) {
        //state: dp[i] = can reach i
        //recurrence: dp[i] = true if dp[j] = true && j < i && nums[j] + j >= i
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] + j >= i) {
                    dp[i] = dp[i] || dp[j];
                }
            }
        }
        return dp[nums.length - 1];
    }
}
