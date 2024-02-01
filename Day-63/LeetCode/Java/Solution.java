/**
 * Problem: Divide Array Into Arrays With Max Difference
 * Description: You are given an integer array nums of size n and a positive integer k.
 *
 * Divide the array into one or more arrays of size 3 satisfying the following conditions:
 *
 * Each element of nums should be in exactly one array.
 * The difference between any two elements in one array is less than or equal to k.
 * Return a 2D array containing all the arrays. If it is impossible to satisfy the conditions, return an empty array. And if there are multiple answers, return any of them.
 */
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n/3][];
        int j = 0;
        for(int i = 0; i <= n - 3; i += 3){
            if(nums[i + 2] - nums[i] > k)
                return new int[0][];
            else {
                ans[j] = Arrays.copyOfRange(nums, i, i + 3);
                j++;
            }
        }
        return ans;
    }
}