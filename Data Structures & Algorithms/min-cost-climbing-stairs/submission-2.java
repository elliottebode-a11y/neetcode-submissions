class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int back1 = cost[1];
        int back2 = cost[0];

        for (int i = 2; i < cost.length; i++) {
            int tmp = cost[i] + Math.min(back1, back2);
            back2 = back1;
            back1 = tmp;
        }
        return Math.min(back1, back2);
    }
}
