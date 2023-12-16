/**
 * Problem: Valid Anagram
 * Description: Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char c : s.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!charFrequency.containsKey(c) || charFrequency.get(c) <= 0) {
                return false;
            }
            charFrequency.put(c, charFrequency.get(c) - 1);
        }

        return true;
    }
}