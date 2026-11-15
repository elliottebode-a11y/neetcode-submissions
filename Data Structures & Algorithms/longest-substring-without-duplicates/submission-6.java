class Solution {
    public int lengthOfLongestSubstring(String s) {
        //sliding window
        if (s.equals("")) return 0;
        int l = 0;
        int r = 1;
        int max = 1;
        Set<Character> hs = new HashSet<>();
        hs.add(s.charAt(l));

        while (l < r && r < s.length()) {
            while (hs.contains(s.charAt(r))) {
                hs.remove(s.charAt(l));
                l++;
            }
            max = Math.max(max, (r - l) + 1);
            hs.add(s.charAt(r));
            r++;
        }
        return max;
    }
}
