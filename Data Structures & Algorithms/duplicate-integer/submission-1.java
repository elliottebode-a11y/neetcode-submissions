class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        for (int i : nums) {
            if (!hm.add(i)) return true;
        }
        return false;
    }
}