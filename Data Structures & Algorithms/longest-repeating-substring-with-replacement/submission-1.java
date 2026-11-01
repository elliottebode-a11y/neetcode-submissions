class Solution {
    public int characterReplacement(String s, int k) {
        //keep a window of all substrings
        //replace most common character in substring
        //record length
        //expand window if k remains
        //shrink until we get k back
        HashMap<Character, Integer> freq = new HashMap<>();
        int maxf = 0;
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            freq.merge(s.charAt(r), 1, Integer::sum);
            maxf = Math.max(freq.get(s.charAt(r)), maxf);
            while ((r - l + 1) - maxf > k) {
                freq.merge(s.charAt(l), -1, Integer::sum);
                l++;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
