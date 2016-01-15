package leetcode.easy;

/**
 * Created by jai around 10/12/15.
 * You are playing the following Nim Game with your friend: There is a heap of stones on the table, each time one of you
 * take turns to remove 1 to 3 stones. The one who removes the last stone will be the winner. You will take the first
 * turn to remove the stones.
 *
 * Both of you are very clever and have optimal strategies for the game. Write a function to determine whether you can
 * win the game given the number of stones in the heap.
 *
 * For example, if there are 4 stones in the heap, then you will never win the game: no matter 1, 2, or 3 stones you
 * remove, the last stone will always be removed by your friend.
 */
public class NimGame {
    public boolean canWinNim(int n) {
        //     if(n < 4) return true;
        //     // boolean[] record = new boolean[n];
        //     // record[0] = record[1] = record[2] == true;
        //     boolean iminus1 = true;
        //     boolean iminus2 = true;
        //     boolean iminus3 = true;
        //     boolean ans = false;
        //     for(int i = 3; i < n; i++) {
        //         ans = false;
        //         if(!iminus1 || !iminus2 || !iminus3) ans = true;
        //         iminus3 = iminus2;
        //         iminus2 = iminus1;
        //         iminus1 = ans;
        //     }
        //     return ans;
        return !(n%4 ==0);
    }
}
