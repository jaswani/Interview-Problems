package leetcode.easy;

/**
 * Created by jai around 10/5/15.
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(!checkRow(board,i)) return false;
        }
        for(int i = 0; i < 9; i++) {
            if(!checkCol(board,i)) return false;
        }
        for(int i = 0; i < 9; i+=3) {
            for(int j = 0; j < 9; j+=3) {
                if(!checkBlk(board,i,j)) return false;
            }
        }
        return true;
    }

    private boolean checkRow(char[][] board, int row) {
        int[] a = new int[9];
        for(int i = 0; i < 9; i++) {
            if(board[row][i] == '.') continue;
            int x = ++a[board[row][i] - '1'];
            if(x > 1) return false;
        }
        return true;
    }

    private boolean checkCol(char[][] board, int col) {
        int[] a = new int[9];
        for(int i = 0; i < 9; i++) {
            if(board[i][col] == '.') continue;
            int x = ++a[board[i][col] - '1'];
            if(x > 1) return false;
        }
        return true;
    }

    private boolean checkBlk(char[][] board, int r, int c) {
        int[] a = new int[9];
        for(int i = r; i < r+3; i++) {
            for(int j = c; j < c+3; j++) {
                if(board[i][j] == '.') continue;
                int x = ++a[board[i][j] - '1'];
                if(x > 1) return false;
            }
        }
        return true;
    }
}
