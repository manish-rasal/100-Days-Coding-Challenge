/**
 * Problem: Find Polygon With the Largest Perimeter
 * Description: You are given an array of positive integers nums of length n.
 *
 * A polygon is a closed plane figure that has at least 3 sides. The longest side of a polygon is smaller than the sum of its other sides.
 *
 * Conversely, if you have k (k >= 3) positive real numbers a1, a2, a3, ..., ak where a1 <= a2 <= a3 <= ... <= ak and a1 + a2 + a3 + ... + ak-1 > ak, then there always exists a polygon with k sides whose lengths are a1, a2, a3, ..., ak.
 *
 * The perimeter of a polygon is the sum of lengths of its sides.
 *
 * Return the largest possible perimeter of a polygon whose sides can be formed from nums, or -1 if it is not possible to create a polygon.
 */
class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long peri = nums[0] + nums[1];
        long sum = peri;
        for(int i = 2; i < n; i++) {
            if(nums[i] < sum) {
                peri = sum + nums[i];
            }
            sum += nums[i];
        }
        return (peri == nums[0] + nums[1])? -1: peri;
    }
}