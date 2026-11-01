class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        if (s.length() == 1) return 1;
        Set<Character> window = new HashSet<>();
        int l = 0;
        int r = 1;
        int max = 0;
        window.add(s.charAt(l));
        
        while (r < s.length()) {
            char c = s.charAt(r);
            while (window.contains(c)) {
                window.remove(s.charAt(l));
                l++;
            }
            window.add(c);
            max = Math.max(max, r-l + 1);
            r++;
        }
        return max;
    }
}
