/**
 * Problem: Partition Array for Maximum Sum
 * Description: Given an integer array arr, partition the array into (contiguous) subarrays of length at most k. After partitioning, each subarray has their values changed to become the maximum value of that subarray.
 *
 * Return the largest sum of the given array after partitioning. Test cases are generated so that the answer fits in a 32-bit integer.
 */
class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n = arr.length;
        int[] t = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            int currMax = -1;

            for (int j = 1; j <= k && i - j >= 0; j++) {
                currMax = Math.max(currMax, arr[i - j]);
                t[i] = Math.max(t[i], t[i - j] + currMax * j);
            }
        }

        return t[n];
    }
}