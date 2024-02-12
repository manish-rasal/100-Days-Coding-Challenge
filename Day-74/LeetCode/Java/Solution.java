/**
 * Problem: Majority Element
 * Description: Given an array nums of size n, return the majority element.
 *
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
class Solution {
    public int majorityElement(int[] nums) {
        int result = nums[0];
        int count = 1;
        for(int i = 1; i < nums.length; i++) {
            if(count == 0) {
                result = nums[i];
                count = 1;
            } else {
                if(nums[i] == result)
                    count++;
                else
                    count--;
            }

        }
        return result;
    }
}