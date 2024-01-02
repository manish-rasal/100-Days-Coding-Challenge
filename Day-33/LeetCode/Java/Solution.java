/**
 * Problem: Convert an Array Into a 2D Array With Conditions
 * Description: You are given an integer array nums. You need to create a 2D array from nums satisfying the following conditions:
 *
 * The 2D array should contain only the elements of the array nums.
 * Each row in the 2D array contains distinct integers.
 * The number of rows in the 2D array should be minimal.
 * Return the resulting array. If there are multiple answers, return any of them.
 *
 * Note that the 2D array can have a different number of elements on each row.
 */
class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> occurences = new HashMap<>();
        for (int i : nums) {
            occurences.put(i, occurences.getOrDefault(i, 0) + 1);
        }
        List<List<Integer>> result = new ArrayList<>();
        int maxRows = 0;
        for (int value : occurences.values()) {
            maxRows = Math.max(maxRows, value);
        }

        for (int i = 0; i < maxRows; i++) {
            result.add(new ArrayList<>());
        }

        for (int key : occurences.keySet()) {
            int count = occurences.get(key);
            for (int i = 0; i < count; i++) {
                result.get(i).add(key);
            }
        }

        return result;
    }
}