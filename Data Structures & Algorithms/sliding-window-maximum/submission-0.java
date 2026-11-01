class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = k - 1;
        int[] sol = new int[nums.length - k + 1];

        //build up window
        //maintain heap of window?
        //track exit/ entrances
        //determine max every window
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        while (r < nums.length) {
            sol[l] = pq.peek();
            pq.remove(nums[l]);
            l++;
            r++;
            if (r < nums.length) {
                pq.add(nums[r]);
            }
        }

        return sol;
    }
}
