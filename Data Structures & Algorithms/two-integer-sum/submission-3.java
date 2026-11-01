class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int dif = target - nums[i];
            if (hm.containsKey(dif)) return new int[] {hm.get(dif), i};
            else hm.put(nums[i], i);
        }
        return null;
    }
}
