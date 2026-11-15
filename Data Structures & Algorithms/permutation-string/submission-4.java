class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) return false;

        //idea
        //frequency list of s1
        //frequency list of window of s2
        //compare

        int[] s1Map = new int[26];
        int[] s2Map = new int[26];

        int l = 0;
        int r = s1.length() - 1;

        for (int i = 0; i < s1.length(); i++) {
            s1Map[s1.charAt(i) - 'a']++;
            s2Map[s2.charAt(i) - 'a']++;
        }

        while (l <= r && r < s2.length()) {
            if (Arrays.equals(s1Map, s2Map)) return true;
            else {
                s2Map[s2.charAt(l) - 'a']--;
                r++;
                if (r < s2.length()) s2Map[s2.charAt(r) - 'a']++;
                l++;
                //s2Map[s2.charAt(l) - 'a']++;
            }
        }
        return false;
    }
}
