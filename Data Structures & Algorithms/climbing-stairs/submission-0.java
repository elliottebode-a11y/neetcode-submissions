class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        return cs(n, memo);
    }

    public int cs(int n, int[] memo) {
        if (n <= 1) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = cs(n - 1, memo) + cs(n - 2, memo);
        return memo[n];
    }
}
