/**
 * Problem: Unique Number of Occurrences
 * Description: Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.
 */
class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        Set<Integer> set = new HashSet<>(map.values());
        return map.size() == set.size();
    }
}