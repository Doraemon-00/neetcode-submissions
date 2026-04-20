class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0, bot = rows - 1;
        while (top <= bot) {
            int midRow = top + ((bot - top) / 2);
            if (target > matrix[midRow][cols - 1]) {
                top = midRow + 1;
            } else if (target < matrix[midRow][0]) {
                bot = midRow - 1;
            } else {
                top = midRow;
                break;
            }
        }

        if (top > bot) return false;

        int l = 0, r = cols - 1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (target > matrix[top][mid]) {
                l = mid + 1;
            } else if (target < matrix[top][mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
