/**
 * Problem: Maximum Odd Binary Number
 * Description: You are given a binary string s that contains at least one '1'.
 *
 * You have to rearrange the bits in such a way that the resulting binary number is the maximum odd binary number that can be created from this combination.
 *
 * Return a string representing the maximum odd binary number that can be created from the given combination.
 *
 * Note that the resulting string can have leading zeros.
 */
class Solution {
    public String maximumOddBinaryNumber(String s) {
        char one = 'x';
        String result = "";
        for(char i: s.toCharArray()) {
            if(i == '1') {
                if(one == '1') {
                    result = i + result;
                } else {
                    one = i;
                }
            } else {
                result = result + i;
            }
        }
        return result + one;
    }
}