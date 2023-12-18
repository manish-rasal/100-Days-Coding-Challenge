/**
 * Problem: Maximum Product Difference Between Two Pairs
 * Description: The product difference between two pairs (a, b) and (c, d) is defined as (a * b) - (c * d).
 *
 * For example, the product difference between (5, 6) and (2, 7) is (5 * 6) - (2 * 7) = 16.
 * Given an integer array nums, choose four distinct indices w, x, y, and z such that the product difference between pairs (nums[w], nums[x]) and (nums[y], nums[z]) is maximized.
 *
 * Return the maximum such product difference.
 */
class Solution {
    public int maxProductDifference(int[] nums) {
        int large = 0, secondLarge = 0;
        int small = 10001, secondSmall = 10001;

        for(int i: nums){
            if(i >= large){
                secondLarge = large;
                large = i;
            }
            if(i < large && i >= secondLarge){
                secondLarge = i;
            }
            if(i <= small){
                secondSmall = small;
                small = i;
            }
            if(i > small && i <= secondSmall){
                secondSmall = i;
            }
        }
        return (large * secondLarge) - (small * secondSmall);
    }
}