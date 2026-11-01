class Solution {
    public boolean isPalindrome(String s) {
        s = s.strip().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        System.out.println(s);
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(j)) return false;
            j--;
        }
        return true;
    }
}
