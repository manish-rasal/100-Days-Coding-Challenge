/**
 * Problem: Count Elements With Maximum Frequency
 * Description: You are given an array nums consisting of positive integers.
 *
 * Return the total frequencies of elements in nums such that those elements all have the maximum frequency.
 *
 * The frequency of an element is the number of occurrences of that element in the array.
 */
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        int maxFreq = 0;
        for(int i: nums) {
            freq[i]++;
            maxFreq = Math.max(maxFreq, freq[i]);
        }
        int result = 0;
        for(int i: freq) {
            if(i == maxFreq) {
                result += maxFreq;
            }
        }
        return result;
    }
}