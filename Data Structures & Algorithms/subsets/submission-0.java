class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sol = new ArrayList<>();
        
        dfs(0, nums, sol, new ArrayList<>());
        return sol;
    }

    public void dfs(int i, int[] nums, List<List<Integer>> sol, List<Integer> work) {
        if (i >= nums.length) {
            sol.add(new ArrayList<>(work));
            return;
        }
        
        work.add(nums[i]);
        dfs(i + 1, nums, sol, work);

        work.remove(work.size() - 1);
        dfs(i + 1, nums, sol, work);
    }
}
