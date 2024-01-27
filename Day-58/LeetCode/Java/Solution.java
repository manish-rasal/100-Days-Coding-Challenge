/**
 * Problem: K Inverse Pairs Array
 * Description: For an integer array nums, an inverse pair is a pair of integers [i, j] where 0 <= i < j < nums.length and nums[i] > nums[j].
 *
 * Given two integers n and k, return the number of different arrays consist of numbers from 1 to n such that there are exactly k inverse pairs. Since the answer can be huge, return it modulo 109 + 7.
 */
class Solution {
    int M = 1000000007;

    public int kInversePairs(int n, int k) {
        int[][] t = new int[n + 1][k + 1];

        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            long cumSum = 1;
            for (int j = 1; j <= k; j++) {

                cumSum += t[i - 1][j];
                if (j >= i) {
                    cumSum -= t[i - 1][j - i];
                }
                t[i][j] = (int) (cumSum % M);
            }
        }

        return t[n][k];
    }
}