/**
 * Problem: Palindromic Substrings
 * Description: Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 */
class Solution {
    private boolean isPalindrome(String s) {
        int i = 0;
        int n = s.length();
        while(i < n) {
            if(s.charAt(i) != s.charAt(n - 1 - i))
                return false;
            i++;
        }
        return true;
    }
    public int countSubstrings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            if(i > 0)
                dp[i] +=dp[i - 1];
            for(int j = 0; j <= i; j++) {
                if(isPalindrome(s.substring(j, i + 1))) {
                    dp[i] += 1;
                }
            }
        }
        return dp[n - 1];
    }
}