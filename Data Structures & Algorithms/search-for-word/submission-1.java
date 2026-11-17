class Solution {
    public boolean exist(char[][] board, String word) {
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, dirs, i, j, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int[][] dirs, int x, int y, int j, boolean[][] visited) {
        if (j == word.length()) {
            return true;
        }

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] != word.charAt(j)) {
            return false;
        }
        visited[x][y] = true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (dfs(board, word, dirs, nx, ny, j + 1, visited)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
