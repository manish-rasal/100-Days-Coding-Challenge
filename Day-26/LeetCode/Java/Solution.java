/**
 * Problem: Number of Dice Rolls With Target Sum
 * Description: You have n dice, and each die has k faces numbered from 1 to k.
 *
 * Given three integers n, k, and target, return the number of possible ways (out of the kn total ways) to roll the dice, so the sum of the face-up numbers equals target. Since the answer may be too large, return it modulo 109 + 7.
 */
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int MOD = 1000000007;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; i++)
            for(int j = 1; j <= target; j++)
                for(int face = 1; face <= k; face++)
                    if(j - face >= 0)
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - face]) % MOD;
        return dp[n][target];
    }
}