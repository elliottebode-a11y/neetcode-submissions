class TrieNode {
    TrieNode[] children = new TrieNode[26];
    int endOfWord = -1;
}

class Solution {
    private TrieNode root = new TrieNode();
    int[][] DIRS = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    List<String> sol = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode cur;
        int ROWS = board.length;
        int COLS = board[0].length;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            cur = root;
            for (char c : word.toCharArray()) {
                if (cur.children[c - 'a'] == null) {
                    cur.children[c - 'a'] = new TrieNode();
                }
                cur = cur.children[c - 'a'];
            }
            cur.endOfWord = i;
        }

        boolean[][] visited = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                int idx = board[i][j] - 'a';
                if (root.children[idx] != null) {
                    dfs(board, root.children[idx], i, j, visited, words);
                }
            }
        }
        return sol;
    }

    private void dfs(char[][] board, TrieNode root, int x, int y, boolean[][] visited, String[] words) {
        if (root == null) {
            return;
        }

        if (root.endOfWord != -1) {
            sol.add(words[root.endOfWord]);
            root.endOfWord = -1;
        }

        visited[x][y] = true;
        for (int[] dir : DIRS) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || visited[nx][ny] || root.children[board[nx][ny] - 'a'] == null) {
                continue;
            }

            dfs(board, root.children[board[nx][ny] - 'a'], nx, ny, visited, words);
        }
        visited[x][y] = false;
    }
}
