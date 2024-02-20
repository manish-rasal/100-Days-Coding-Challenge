/**
 * Problem: Missing Number
 * Description: Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
 */
class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for(int i: nums)
            sum += i;
        return  n * (n + 1) / 2 - sum;
    }
}