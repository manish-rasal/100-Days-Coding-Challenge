/**
 * Problem: Minimum Changes To Make Alternating Binary String
 * Description: You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
 *
 * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
 *
 * Return the minimum number of operations needed to make s alternating.
 */
class Solution {
    public int minOperations(String s) {
        int n = s.length(), starting1 = 0, starting0 = 0;
        for(int i = 0; i < n; i++) {
            if(i % 2 == 0) {
                if(s.charAt(i) == '1')
                    starting0 += 1;
                else
                    starting1 += 1;
            } else {
                if(s.charAt(i) == '1')
                    starting1 += 1;
                else
                    starting0 += 1;
            }
        }
        return Math.min(starting0, starting1);
    }
}