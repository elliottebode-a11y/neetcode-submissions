class Solution {
    private int dist(int[] point) {
        return (int) (Math.pow(point[0], 2) + Math.pow(point[1], 2));
    }

    public int[][] kClosest(int[][] points, int k) {
        int[][] sol = new int[k][2];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(dist(points[a]), dist(points[b])));

        for (int i = 0; i < points.length; i++) {
            pq.offer(i);
        }

        for (int i = 0; i < k; i++) {
            sol[i] = points[pq.poll()];
        }
        return sol;

    }
}
