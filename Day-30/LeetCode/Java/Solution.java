/**
 * Problem: Redistribute Characters to Make All Strings Equal
 * Description: You are given an array of strings words (0-indexed).
 *
 * In one operation, pick two distinct indices i and j, where words[i] is a non-empty string, and move any character from words[i] to any position in words[j].
 *
 * Return true if you can make every string in words equal using any number of operations, and false otherwise.
 */
class Solution {
    public boolean makeEqual(String[] words) {
        String total = "";
        for(String str: words){
            total += str;
        }
        int[] chars = new int[26];
        for(int i = 0; i < total.length(); i++) {
            chars[((int) total.charAt(i)) - 97]++;
        }
        for(int i = 0; i < 26; i++)
            if(chars[i] % words.length != 0)
                return false;
        return true;
    }
}