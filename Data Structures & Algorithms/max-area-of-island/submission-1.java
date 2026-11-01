class Solution {
    int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, dfs(grid, i, j, rows, cols));
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int r, int c, int rows, int cols) {
        int count = 1;
        grid[r][c] = 0;
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (nr < rows && nr >= 0 && nc < cols && nc >= 0 && grid[nr][nc] == 1) {
                count += dfs(grid, nr, nc, rows, cols);
            }
        }
        return count;
    }
}
