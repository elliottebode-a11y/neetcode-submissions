class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        //dp[x][y] = min cost of paid painter doing wall x and also covering y total walls
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n + 1; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        dp[0][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                int prev = Math.max(0, j - time[i - 1] - 1);
                int take = Integer.MAX_VALUE;
                if (dp[i - 1][prev] != Integer.MAX_VALUE) {
                    take = cost[i - 1] + dp[i - 1][Math.max(0, j - time[i - 1] - 1)];
                }
                dp[i][j] = Math.min(take, dp[i - 1][j]);
            }
        }
        return dp[n][n];
    }
}
