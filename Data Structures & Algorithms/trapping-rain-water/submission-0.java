class Solution {
    public int trap(int[] height) {
        //plan- create array of the maximum neighbor to the right
        //for any cell, if there is a larger neighbor to the right, it can hold min(large, current) - i water
        int[] maxRight = new int[height.length];
        int[] maxLeft = new int[height.length];
        int max = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            maxRight[i] = max;
        }
        max = 0;
        for (int i = 0; i < height.length; i++) {
            max = Math.max(max, height[i]);
            maxLeft[i] = max;
        }

        //max water is Max(min(left, right) - current height, 0).

        int agg = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int check = Math.max(Math.min(maxRight[i], maxLeft[i]) - height[i], 0);
            //System.out.printf("Eval %d: %d\n", i, check);
            agg += check;
        }
        return agg;
    }
}
