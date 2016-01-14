package leetcode.medium;

/**
 * Created by jai around 10/5/15.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * For example,
 *
 * Consider the following matrix:
 *
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int i = 0, j = col-1;
        while(isBetween(i, 0, row-1) && isBetween(j,0, col-1)) {
            if(matrix[i][j] == target) return true;
            else if(matrix[i][j] < target) i++;
            else j--;
        }
        return false;
    }

    private boolean isBetween(int val, int low, int high) {
        return (val >= low && val <= high);
    }
}
