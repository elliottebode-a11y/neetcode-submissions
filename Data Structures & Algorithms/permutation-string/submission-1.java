class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        HashMap<Character, Integer> freq2 = new HashMap<>();
        HashMap<Character, Integer> freq1 = new HashMap<>();
        
        //sliding window of size s1.length()
        //if the freqs of this window match freqs s1, we're good
        //else, move window one right

        int l = 0;
        int r = s1.length() - 1;

        for (int i = 0; i < s1.length(); i++) {
            freq1.merge(s1.charAt(i), 1, Integer::sum);
            freq2.merge(s2.charAt(i), 1, Integer::sum);
        }

        while (r < s2.length() - 1) {
            if (freq1.equals(freq2)) return true;
            freq2.merge(s2.charAt(l), -1, Integer::sum);
            if (freq2.get(s2.charAt(l)) <= 0) freq2.remove(s2.charAt(l));
            r++;
            l++;
            freq2.merge(s2.charAt(r), 1, Integer::sum);
        }
        if (freq1.equals(freq2)) return true;
        return false;
    }
}
