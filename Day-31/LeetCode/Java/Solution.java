/**
 * Problem: Largest Substring Between Two Equal Characters
 * Description: Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.
 *
 * A substring is a contiguous sequence of characters within a string.
 */
class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int j = s.length() - 1, result = -1;
        while(j > 0) {
            int i = 0;
            while(i < j) {
                if(s.charAt(i) == s.charAt(j)){
                    result = Math.max(result, j - i -1);
                }
                i++;
            }
            j--;
        }
        return result;
    }
}