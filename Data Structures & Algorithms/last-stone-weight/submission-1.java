class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) {
            pq.offer(i);
        }
        while (pq.size() >= 2) {
            int fir = pq.poll();
            int sec = pq.poll();
            if (fir != sec) {
                fir = fir - sec;
                pq.offer(fir);
            }
        }
        if (pq.size() == 1) return pq.poll();
        return 0;
    }
}
