/**
 * Problem: Maximum Profit in Job Scheduling
 * Description: We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].
 *
 * You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.
 *
 * If you choose a job that ends at time X you will be able to start another job that starts at time X.
 */
class Solution {
    private int binarySearch(int[][] jobs, int end, int left, int right) {
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (jobs[mid][1] <= end) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(m -> m[1]));

        int[] dp = new int[n];
        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {
            int prev = 0;
            int lastJobIndex = binarySearch(jobs, jobs[i][0], 0, i - 1);

            if (lastJobIndex != -1) {
                prev = dp[lastJobIndex];
            }

            dp[i] = Math.max(prev + jobs[i][2], dp[i - 1]);
        }

        return dp[n - 1];
    }
}