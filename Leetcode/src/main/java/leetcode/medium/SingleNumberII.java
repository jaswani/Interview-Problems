package leetcode.medium;

/**
 * Created by jai around 10/12/15.
 * Given an array of integers, every element appears three times except for one. Find that single one.
 *
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        //Slightly cheated, with the concept. the basic idea is all the 1's in the bits will
        //repeat exactly thrics for repeated numbes and the single number will make the count
        //not divisible by three. This can be solved in O(nlgn) by counting bits at each index.
        //But bit magic can do it in linear order.
        int ones = 0; //Set bits are repeated 1,4,7... times
        int twos = 0; //Set bits are repeated 2,5,8,...times
        int threes = 0; //Set bits are repeated 3,6,9 .. times
        for(int i = 0 ; i < nums.length; i++) {
            // System.out.println();
            int s = threes & nums[i]; //This and will contain bits repeated 3x+1 times, move later to ones
            threes &= ~s; //Remove the bits computed above from 3's
            threes |= twos & nums[i]; //Update the bits whose count now becomes 3x with introduction of nums[i]
            twos &= ~threes; //Remove the bits set above from two's
            twos |= ones & nums[i]; //Update the bits whose count now becomes 3x+2 with introduction of nums[i]
            ones ^= nums[i]; //xor will automatically get rid of twos component, so this will contain bit the occur 3x and 3x+1 times
            ones &= ~threes; // remove bits occuring 3x times
            ones |= s; //Add the bits saved earlier to the ans
            // System.out.println(Integer.toBinaryString(ones));
            // System.out.println(Integer.toBinaryString(twos));
            // System.out.println(Integer.toBinaryString(threes));
        }
        return ones;
    }
}
