class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0;
        int rp = numbers.length - 1;
        int cur;

        while (lp < rp) {
            cur = numbers[lp] + numbers[rp];
            if (cur > target) {
                rp--;
            } else if (cur < target) {
                lp++;
            } else {
                return new int[] {lp + 1, rp + 1};
            }
        }
        return new int[] {};
    }
}
