/**
 * Problem: Largest 3-Same-Digit Number in String
 * Description: You are given a string num representing a large integer. An integer is good if it meets the following conditions:
 *
 * It is a substring of num with length 3.
 * It consists of only one unique digit.
 * Return the maximum good integer as a string or an empty string "" if no such integer exists.
 *
 * Note:
 *
 * A substring is a contiguous sequence of characters within a string.
 * There may be leading zeroes in num or a good integer.
 */
class Solution {
    public String largestGoodInteger(String num) {
        String result = "", temp = "";
        char initial = num.charAt(0);
        temp += initial;

        for (int i = 1; i < num.length(); i++) {
            if (initial == num.charAt(i)) {
                temp += initial;
            } else {
                temp = String.valueOf(num.charAt(i));
            }

            if (temp.length() == 3) {
                if (result.equals("") || Integer.parseInt(temp) > Integer.parseInt(result)) {
                    result = temp;
                }
                temp = "";
            }

            initial = num.charAt(i);
        }

        return result;
    }
}