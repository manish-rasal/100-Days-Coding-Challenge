/**
 * Problem: Number of Laser Beams in a Bank
 * Description: Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.
 *
 * There is one laser beam between any two security devices if both conditions are met:
 *
 * The two devices are located on two different rows: r1 and r2, where r1 < r2.
 * For each row i where r1 < i < r2, there are no security devices in the ith row.
 * Laser beams are independent, i.e., one beam does not interfere nor join with another.
 *
 * Return the total number of laser beams in the bank.
 */
class Solution {

    public int countOccurrences(String inputString, char character) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }

    public int numberOfBeams(String[] bank) {
        int result = 0;
        int[] countOfOnes = new int[bank.length];
        for(int i = 0; i < bank.length; i++) {
            countOfOnes[i] = countOccurrences(bank[i], '1');
        }
        int prev = 0, current = 0, i = 0;
        while(i < bank.length) {
            if(countOfOnes[i] != 0) {
                prev = current;
                current = countOfOnes[i];
                result += prev * current;
            }
            i++;
        }
        return result;
    }
}