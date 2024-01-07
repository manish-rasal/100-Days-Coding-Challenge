/**
 * Problem: Arithmetic Slices II - Subsequence
 * Description: Given an integer array nums, return the number of all the arithmetic subsequences of nums.
 *
 * A sequence of numbers is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [3, -1, -5, -9] are arithmetic sequences.
 * For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
 * A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 *
 * For example, [2,5,10] is a subsequence of [1,2,1,2,4,1,5,10].
 * The test cases are generated so that the answer fits in 32-bit integer.
 */
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int result = 0;
        Map<Long, Integer>[] mp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            mp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                int count_at_j = mp[j].getOrDefault(diff, 0);

                result += count_at_j;
                mp[i].put(diff, mp[i].getOrDefault(diff, 0) + count_at_j + 1);
            }
        }
        return result;
    }
}