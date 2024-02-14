/**
 * Problem: Find First Palindromic String in the Array
 * Description: Given an array of strings words, return the first palindromic string in the array. If there is no such string, return an empty string "".
 *
 * A string is palindromic if it reads the same forward and backward.
 */
class Solution {
    public String firstPalindrome(String[] words) {
        for(String str: words) {
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            String reversedStr = sb.toString();
            if(str.equals(reversedStr))
                return str;
        }
        return "";
    }
}