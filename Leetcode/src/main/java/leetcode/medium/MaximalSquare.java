package leetcode.medium;

/**
 * Created by jai around 10/12/15.
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.
 *
 * For example, given the following matrix:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 * Return 4.
 */
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        if(matrix.length == 0) return 0;
        if(matrix.length == 1) {
            for(int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == '1') return 1;
            }
            return 0;
        }

        if(matrix[0].length == 1) {
            for(int i = 0; i < matrix.length; i++) {
                if (matrix[i][0] == '1') return 1;
            }
            return 0;
        }

        for(int i = 0; i < matrix.length-1; i++) {
            for(int j = 0; j < matrix[i].length-1; j++) {
                int _oo = matrix[i][j] - '0';
                int _o1 = matrix[i][j+1] - '0';
                int _1o = matrix[i+1][j] - '0';
                int _11 = matrix[i+1][j+1] - '0';
                int val = Math.min(Math.min(_oo,_o1),_1o);
                if(matrix[i+1][j+1] != '0') {
                    matrix[i+1][j+1] =  (char)(_11+val+'0');
                    if (_11 + val > max) max = _11 + val;
                }
            }
        }

        if(max == 0) {
            for(int i = 0; i < matrix.length; i++) {
                if (matrix[i][matrix[0].length-1] == '1') return 1;
            }
            for(int i = 0; i < matrix[0].length; i++) {
                if (matrix[matrix[0].length-1][i] == '1') return 1;
            }
        }

        return max*max;
    }
}
