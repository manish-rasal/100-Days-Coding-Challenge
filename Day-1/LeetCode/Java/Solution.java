/**
 * Problem: Check If Two String Arrays are Equivalent
 *
 * Description: Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *              A string is represented by an array if the array elements concatenated in order forms the string.
 */

class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        String str1 = "", str2 = "";
        for(String i: word1)
            str1 += i;
        for(String j: word2)
            str2 += j;
        return str1.equals(str2);

    }
}