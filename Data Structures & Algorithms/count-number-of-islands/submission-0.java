class Solution {
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> q = new ArrayDeque<>();
        int islands = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    q.offer(new int[] {i, j});
                    bfs(q, grid, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void bfs(Queue<int[]> q, char[][] grid, int rows, int cols) {
        //Queue<int[]> q = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int[] coord = q.poll();
            int r = coord[0];
            int c = coord[1];
            int nr, nc;
            grid[r][c] = '0';
            for (int[] dir : dirs) {
                nr = r + dir[0];
                nc = c + dir[1];
                if (nr < rows && nr >= 0 && nc < cols && nc >= 0) {
                    if (grid[nr][nc] == '1') {
                        q.offer(new int[] {nr, nc});
                        grid[nr][nc] = '0';
                    }
                }
            }
        }
    }
}
