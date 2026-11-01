class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> sm = new HashMap<>();
        HashMap<Character, Integer> tm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sm.merge(s.charAt(i), 1, Integer::sum);
            tm.merge(t.charAt(i), 1, Integer::sum);
        }
        if (!tm.equals(sm)) return false;
        return true;
    }
}
