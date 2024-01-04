/**
 * Problem: Minimum Number of Operations to Make Array Empty
 * Description: You are given a 0-indexed array nums consisting of positive integers.
 *
 * There are two types of operations that you can apply on the array any number of times:
 *
 * Choose two elements with equal values and delete them from the array.
 * Choose three elements with equal values and delete them from the array.
 * Return the minimum number of operations required to make the array empty, or -1 if it is not possible.
 */
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        int result = 0;
        for (int i : mp.keySet()) {
            int freq = mp.get(i);

            if (freq == 1) {
                return -1;
            }
            result += Math.ceil((double) freq / 3);
        }
        return result;
    }
}