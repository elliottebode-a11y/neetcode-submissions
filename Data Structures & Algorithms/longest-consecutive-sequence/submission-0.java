class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int sol = 0;
        int tmp = 0;
        int cur = 0;
        for (int i : nums) {
            hs.add(i);
        }
        for (int i : nums) {
            if (!hs.contains(i - 1)) {
                cur = i;
                tmp = 1;
                while (hs.contains(cur + 1)) {
                    tmp++;
                    cur++;
                }
                sol = Math.max(sol, tmp);
                tmp = 0;
            }
        }
        
        return sol;
    }
}
