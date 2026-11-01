class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] square = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            square[i] = new HashSet<>();
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !row[i].add(board[i][j])) return false;
                if (board[i][j] != '.' && !col[j].add(board[i][j])) return false;
                if (board[i][j] != '.' && !square[(i / 3) * 3 + (j / 3)].add(board[i][j])) return false;
            }
        }
        return true;
    }
}
