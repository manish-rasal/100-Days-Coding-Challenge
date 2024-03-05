/**
 * Problem: Minimum Length of String After Deleting Similar Ends
 * Description: Given a string s consisting only of characters 'a', 'b', and 'c'. You are asked to apply the following algorithm on the string any number of times:
 *
 * Pick a non-empty prefix from the string s where all the characters in the prefix are equal.
 * Pick a non-empty suffix from the string s where all the characters in this suffix are equal.
 * The prefix and the suffix should not intersect at any index.
 * The characters from the prefix and suffix must be the same.
 * Delete both the prefix and the suffix.
 * Return the minimum length of s after performing the above operation any number of times (possibly zero times).
 */
class Solution {
    public int minimumLength(String s) {
        if(s.length() == 1) return 1;
        int n = s.length();
        int r = n - 1, l = 0;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)){
                break;
            } else {
                if(l + 1 < r && s.charAt(l + 1) == s.charAt(r)) {
                    l++;
                } else if(l < r - 1 && s.charAt(l) == s.charAt(r - 1)) {
                    r--;
                } else {
                    l++;
                    r--;
                }
            }

        }
        return r - l + 1;
    }
}