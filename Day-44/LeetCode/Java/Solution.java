/**
 * Problem: Minimum Number of Steps to Make Two Strings Anagram
 * Description: You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.
 *
 * Return the minimum number of steps to make t an anagram of s.
 *
 * An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.
 */
class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();

        int[] mp_s = new int[26];
        int[] mp_t = new int[26];

        for (int i = 0; i < n; i++) {
            mp_s[s.charAt(i) - 'a']++;
            mp_t[t.charAt(i) - 'a']++;
        }

        int result = 0;

        for (int i = 0; i < 26; i++) {
            int freq_in_t = mp_t[i];
            int freq_in_s = mp_s[i];

            if (freq_in_t < freq_in_s) {
                result += freq_in_s - freq_in_t;
            }
        }

        return result;
    }
}