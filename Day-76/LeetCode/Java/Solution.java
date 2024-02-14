/**
 * Problem: Rearrange Array Elements by Sign
 * Description: You are given a 0-indexed integer array nums of even length consisting of an equal number of positive and negative integers.
 *
 * You should rearrange the elements of nums such that the modified array follows the given conditions:
 *
 * Every consecutive pair of integers have opposite signs.
 * For all integers with the same sign, the order in which they were present in nums is preserved.
 * The rearranged array begins with a positive integer.
 * Return the modified array after rearranging the elements to satisfy the aforementioned conditions.
 */
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int pos = 0, neg = 1;
        for(int i: nums) {
            if(i > 0) {
                result[pos] = i;
                pos += 2;
            } else {
                result[neg] = i;
                neg += 2;
            }
        }
        return result;
    }
}