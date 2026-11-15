class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int l = i + 1;
            int r = nums.length - 1;
            while (r > l) {
                if (nums[l] + nums[r] > -nums[i]) r--;
                else if (nums[l] + nums[r] < -nums[i]) l++;
                else {
                    res.add(new ArrayList<>(List.of(nums[l], nums[r], nums[i])));
                    r--;
                    l++;
                    while (l < nums.length && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
        }
        return res;
    }
}
