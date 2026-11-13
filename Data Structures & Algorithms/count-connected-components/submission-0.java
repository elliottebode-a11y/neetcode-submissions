class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        int cc = 0;
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                q.offer(i);
                visited[i] = true;
                cc++;
            }
            while (!q.isEmpty()) {
                int node = q.poll();
                for (int neb : adjList.get(node)) {
                    if (!visited[neb]) {
                        q.offer(neb);
                        visited[neb] = true;
                    }
                }
            }
        }
        return cc;
    }
}
