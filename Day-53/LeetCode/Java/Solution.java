/**
 * Problem: Set Mismatch
 * Description: You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 */
class Solution {
    private int findDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int n = nums.length;
        int actualSum = 0;
        for(int i: nums)
            actualSum += i;
        int duplicate = findDuplicate(nums);
        result[0] = duplicate;
        result[1] = (n * (n + 1)) / 2 - (actualSum - duplicate);
        return result;
    }
}