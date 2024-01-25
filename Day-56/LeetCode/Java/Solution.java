/**
 * Problem: Longest Common Subsequence
 * Description: Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
 *
 * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
 *
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both strings.
 */
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1][n2];
        for(int i = 0; i < n1; i++) {
            for(int j = 0; j < n2; j++) {
                if(i == 0 && j == 0) {
                    if(text1.charAt(0) == text2.charAt(0))
                        dp[0][0] = 1;
                } else if(i == 0) {
                    if(text1.charAt(0) == text2.charAt(j))
                        dp[0][j] = 1;
                    else
                        dp[0][j] = dp[0][j - 1];

                } else if(j == 0){
                    if(text1.charAt(i) == text2.charAt(0))
                        dp[i][0] = 1;
                    else
                        dp[i][0] = dp[i - 1][0];
                } else {
                    if(text1.charAt(i) == text2.charAt(j)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[n1 - 1][n2 - 1];
    }
}