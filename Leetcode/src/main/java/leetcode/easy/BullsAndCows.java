package leetcode.easy;

/**
 * Created by jai around 11/9/15.
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to
 * guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in
 * said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the
 * secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to
 * eventually derive the secret number.
 *
 * For example:
 *
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and
 * B to indicate the cows. In the above example, your function should return "1A3B".
 *
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 *
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return
 * "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 */
public class BullsAndCows {
    public String getHint(String secret, String guess) {
        // char[] s = secret.toCharArray();
        // char[] g = guess.toCharArray();
        // int bull = 0;
        // int cow = 0;

        // for(int i = 0; i < secret.length(); i++) {
        //     if(s[i] == g[i]) {
        //         //bull
        //         s[i] = g[i] = 'A';
        //         bull++;

        //     }
        // }

        // for(int i = 0; i < g.length; i++) {
        //     if(g[i] == 'A') continue;
        //     for(int j = 0; j < s.length; j++) {
        //         if(g[i] == s[j]) {
        //             //cow
        //             s[j] = g[i] = 'B';
        //             cow++;
        //             break;
        //         }
        //     }
        // }

        // return (bull +"A" + cow + "B");
        return getHintFast(secret, guess);
    }

    public String getHintFast(String secret, String guess) {
        int[] s = new int[10];
        int[] g = new int[10];
        int bull = 0;
        int cows = 0;

        for(int i = 0 ; i < secret.length(); i++) {
            s[secret.charAt(i) - 48]++;
            g[guess.charAt(i) - 48]++;
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            }
        }

        for(int i=0; i < 10; i++) {
            cows += Math.min(s[i], g[i]);
        }

        return (bull + "A" + (cows-bull) + "B");
    }
}
