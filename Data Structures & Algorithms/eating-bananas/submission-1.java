class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int len = piles.length;
        //looks like we can have up to h piles total
        //this question is asking
        int r = 0;
        int l = 1;
        for (int i = 0; i < len; i++) {
            r = Math.max(r, piles[i]);
        }

        //workable eating rate is bounded at r
        //verify whether we have < h piles at various points
        int speed = r;
        while (l <= r) {
            int comp = 0;
            int m = (l + r) / 2;
            for (int i = 0; i < len; i++) {
                comp += Math.ceil((double) piles[i] / m);
            }
            if (comp <= h) {
                    r = m - 1;
                    speed = Math.min(speed, m);
            } else {
                l = m + 1;
            }
        }
        return speed;
    }
}
