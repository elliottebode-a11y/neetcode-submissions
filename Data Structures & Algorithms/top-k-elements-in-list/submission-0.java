class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i : nums) {
            freqMap.merge(i, 1, Integer::sum);
        }
        
        //want to create array of lists
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            freq[i] = new ArrayList<>();
        }
        for (HashMap.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] sol = new int[k];
        int inx = 0;
        for (int i = nums.length; i > 0; i--) {
            for (int n : freq[i]) {
                sol[inx] = n;
                inx++;
            }
            if (inx == k) return sol;
        }
        return sol;
    }
}
