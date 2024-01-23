/**
 * Problem: Maximum Length of a Concatenated String with Unique Characters
 * Description: You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
 *
 * Return the maximum possible length of s.
 *
 * A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
 */
class Solution {
    public int maxLength(List<String> arr) {
        return solve(0, arr, "", arr.size(), new HashMap<>());
    }

    private boolean hasCommon(String s1, String s2) {
        int[] arr = new int[26];

        for (char ch : s1.toCharArray()) {
            if (arr[ch - 'a'] > 0)
                return true;
            arr[ch - 'a']++;
        }

        for (char ch : s2.toCharArray()) {
            if (arr[ch - 'a'] > 0)
                return true;
        }

        return false;
    }

    private int solve(int idx, List<String> arr, String temp, int n, Map<String, Integer> memo) {
        if (idx >= n)
            return temp.length();

        String key = temp + idx;
        if (memo.containsKey(key))
            return memo.get(key);

        int include = 0;
        int exclude = 0;
        if (!hasCommon(arr.get(idx), temp)) {
            temp += arr.get(idx);
            include = solve(idx + 1, arr, temp, n, memo);
            temp = temp.substring(0, temp.length() - arr.get(idx).length());
        }
        exclude = solve(idx + 1, arr, temp, n, memo);

        int result = Math.max(include, exclude);
        memo.put(key, result);
        return result;
    }
}