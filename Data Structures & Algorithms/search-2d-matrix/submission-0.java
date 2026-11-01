class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //initial thoughts
        //binary search with [row, column]
        //compare columns first
            //if not in range, bin search on column
            //if in range, bin search on row

        int rows = matrix.length;
        int cols = matrix[0].length;
        //there are row*col - 1 inx in the array
        //row is going to be m / col, col is m % col
        int l = 0;
        int r = rows * cols - 1;

        while (l <= r) {
            int mid = (l + r) / 2;
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) return true;
            else if (matrix[row][col] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return false;
    }
}
