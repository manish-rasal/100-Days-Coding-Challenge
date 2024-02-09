/**
 * Problem: Largest Divisible Subset
 * Description: Given a set of distinct positive integers nums, return the largest subset answer such that every pair (answer[i], answer[j]) of elements in this subset satisfies:
 *
 * answer[i] % answer[j] == 0, or
 * answer[j] % answer[i] == 0
 * If there are multiple solutions, return any of them.
 */
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 0, k = 0;
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] % nums[j] == 0) {
                    if(dp[i] < dp[j] + 1){
                        dp[i] = 1 + dp[j];
                        prev[i] = j;
                    }
                    if(dp[i] > maxLen) {
                        maxLen = dp[i];
                        k = i;
                    }
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        do {
            result.add(nums[k]);
            k = prev[k];
        } while(k != -1);

        return result;
    }
}