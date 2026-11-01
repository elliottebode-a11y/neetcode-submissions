class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int minLeft = 1000;

        for (int i : prices) {
            maxDiff = Math.max(maxDiff, i - minLeft);
            minLeft = Math.min(i, minLeft);
        }
        return maxDiff;
    }
}
