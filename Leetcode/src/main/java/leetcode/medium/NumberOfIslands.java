package leetcode.medium;

/**
 * Created by jai around 10/12/15.
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 *
 * Example 1:
 *
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 *
 * Example 2:
 *
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int count=0;
        for(int i=0; i < grid.length; i++) {
            for(int j =0; j < grid[0].length; j++) {
                if (grid[i][j] == '0' || grid[i][j] == '2') continue;
                count++;
                markIsland(i,j,grid);
            }
        }
        return count;
    }

    public void markIsland(int i, int j , char[][] grid) {
        if (grid[i][j] == '0' || grid[i][j] == '2') return;
        //grid value is 1
        grid[i][j] = '2';
        if(i < grid.length-1) markIsland(i+1,j, grid);
        if(i > 0) markIsland(i-1,j, grid);
        if(j < grid[0].length-1) markIsland(i,j+1, grid);
        if(j > 0) markIsland(i,j-1, grid);
    }
}
