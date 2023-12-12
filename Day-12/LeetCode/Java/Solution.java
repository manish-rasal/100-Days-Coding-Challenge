/**
 * Problem: Maximum Product of Two Elements in an Array
 * Description: Given the array of integers nums, you will choose two different indices i and j of that array. Return the maximum value of (nums[i]-1)*(nums[j]-1).
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0;

        for (int num : nums) {
            if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}