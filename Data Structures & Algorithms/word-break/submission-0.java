class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] = true if word can be formed here
        //seems like a looping problem
        //dp[i] = true if substr[0, i] in list or substr[0, j] and substr[j, i] in list
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            boolean noSplit = wordDict.contains(s.substring(0, i));
            for (int j = 0; j < i; j++) {
                dp[i] = noSplit || (dp[j] && wordDict.contains(s.substring(j, i)));
                if (dp[i]) break;
            }
        }
        return dp[s.length()];
    }
}
