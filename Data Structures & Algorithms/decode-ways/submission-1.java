class Solution {
    public int numDecodings(String s) {
        //int[] dp = new int[s.length()];
        if (s.charAt(0) == '0') return 0;
        int back1 = 1;
        int back2 = 1;

        for (int i = 1; i < s.length(); i++) {
            int c = s.charAt(i) - '0';
            int prev = s.charAt(i - 1) - '0';
            int tmp = 0;
            if (c != 0) {
                tmp += back1;
                // dp[i] += dp[i - 1];
            }
            if (prev * 10 + c >= 10 && prev * 10 + c <= 26) {
                tmp += back2;
                // dp[i] += (i > 1 ? dp[i - 2] : 1);
            }
            back2 = back1;
            back1 = tmp;
        }
        return back1;
    }
}
