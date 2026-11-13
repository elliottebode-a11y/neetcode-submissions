class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') return 0;
        dp[0] = 1;

        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            if (c != 0) {
                dp[i] += dp[i - 1];
            }
            if (prev * 10 + c >= 10 && prev * 10 + c <= 26) {
                dp[i] += (i > 1 ? dp[i - 2] : 1);
            }
        }
        return dp[s.length() - 1];
    }
}
