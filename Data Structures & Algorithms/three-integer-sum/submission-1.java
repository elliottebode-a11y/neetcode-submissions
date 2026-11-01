class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int fp;
        int sp;
        int target;
        int cur;
        List<List<Integer>> sol = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            target = 0 - nums[i];
            sp = nums.length - 1;
            fp = i + 1;
            while (fp < sp) {
                cur = nums[fp] + nums[sp];
                if (cur > target) {
                    sp--;
                } else if (cur < target) {
                    fp++;
                } else {
                    sol.add(new ArrayList<>(List.of(nums[i], nums[fp], nums[sp])));
                    fp++;
                    sp--;
                    while (fp < sp &&
                           nums[fp] == nums[fp - 1]) {
                        fp++;
                    }

                    // Skip duplicate right-pointer values
                    while (fp < sp &&
                           nums[sp] == nums[sp + 1]) {
                        sp--;
                    }
                }
            }
        }
        return sol;
    }
}
