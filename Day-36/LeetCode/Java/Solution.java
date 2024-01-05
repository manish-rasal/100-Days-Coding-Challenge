/**
 * Problem: Longest Increasing Subsequence
 * Description: Given an integer array nums, return the length of the longest strictly increasing
 * subsequence.
 */
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 1;
        for (int len : dp) {
            max = Math.max(max, len);
        }
        return max;
    }
}