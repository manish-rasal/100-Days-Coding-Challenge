/**
 * Problem: Minimum Difficulty of a Job Schedule
 * Description: You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, you have to finish all the jobs j where 0 <= j < i).
 *
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a job done on that day.
 *
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is jobDifficulty[i].
 *
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 */
class Solution {

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;

        if (n < d)
            return -1;

        int[][] t = new int[n + 1][d + 1];
        for (int i = 0; i < n; i++) {
            t[i][1] = Arrays.stream(Arrays.copyOfRange(jobDifficulty, i, n)).max().orElse(Integer.MIN_VALUE);
        }
        for (int days = 2; days <= d; days++) {
            for (int i = 0; i <= n - days; i++) {
                int maxDifficulty = Integer.MIN_VALUE;
                int result = Integer.MAX_VALUE;

                for (int j = i; j <= n - days; j++) {
                    maxDifficulty = Math.max(maxDifficulty, jobDifficulty[j]);
                    result = Math.min(result, maxDifficulty + t[j + 1][days - 1]);
                }

                t[i][days] = result;
            }
        }

        return t[0][d];
    }
}