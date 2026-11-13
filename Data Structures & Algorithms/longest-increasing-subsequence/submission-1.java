class Solution {
    public int lengthOfLIS(int[] nums) {
        //longest increasing subsequence is max(dp[j]) + 1 s.t. j < i && nums[i] > nums[j]

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int best = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = dp[j] + 1 > dp[i] ? (dp[j]) + 1 : dp[i];
                    best = dp[i] > best ? dp[i] : best;
                }
            }
        }
        return best;
    }
}
