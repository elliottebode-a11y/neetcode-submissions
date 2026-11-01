class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) {
            if (hm.get(i) == null) {
                hm.put(i, 1);
            } else return true;
        }
        return false;
    }
}