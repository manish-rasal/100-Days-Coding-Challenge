/**
 * Problem: First Unique Character in a String
 * Description: Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
 */
class Solution {
    public int firstUniqChar(String s) {
        int[] charFreq = new int[26];
        for(int i = s.length() - 1; i >= 0; i--) {
            charFreq[s.charAt(i) - 97] += 1;
        }
        for(int i = 0; i < s.length(); i++){
            if(charFreq[s.charAt(i) - 97] == 1)
                return i;
        }
        return -1;
    }
}