/**
 * Problem: Determine if Two Strings Are Close
 * Description: Two strings are considered close if you can attain one from the other using the following operations:
 *
 * Operation 1: Swap any two existing characters.
 * For example, abcde -> aecdb
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 */
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        int[] charFreq1 = new int[26];
        int[] charFreq2 = new int[26];
        for(int i = 0; i < word1.length(); i++) {
            charFreq1[word1.charAt(i) - 97]++;
            charFreq2[word2.charAt(i) - 97]++;
        }
        Arrays.sort(charFreq1);
        Arrays.sort(charFreq2);
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char c : word1.toCharArray()) {
            set1.add(c);
        }

        for (char c : word2.toCharArray()) {
            set2.add(c);
        }
        return Arrays.equals(charFreq1, charFreq2) && set1.equals(set2);
    }
}