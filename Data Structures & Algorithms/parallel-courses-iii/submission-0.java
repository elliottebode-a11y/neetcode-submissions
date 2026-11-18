class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        //bfs solution:
        //find indegree = 0, add to queue
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[n];
        int[] max = Arrays.copyOf(time, n);
        for (int i = 0; i < time.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] relation : relations) {
            adjList.get(relation[0] - 1).add(relation[1] - 1);
            indegree[relation[1] - 1]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neb : adjList.get(node)) {
                indegree[neb]--;
                max[neb] = Math.max(max[neb], max[node] + time[neb]);
                if (indegree[neb] == 0) {
                    q.offer(neb);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, max[i]);
        }
        return ans;

    }
}
