/**
 * Problem: Difference Between Ones and Zeros in Row and Column
 * Description: You are given a 0-indexed m x n binary matrix grid.
 *
 * A 0-indexed m x n difference matrix diff is created with the following procedure:
 *
 * Let the number of ones in the ith row be onesRowi.
 * Let the number of ones in the jth column be onesColj.
 * Let the number of zeros in the ith row be zerosRowi.
 * Let the number of zeros in the jth column be zerosColj.
 * diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
 * Return the difference matrix diff.
 */
class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] rowSum = new int[m];
        int[] colSum = new int[n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        int[][] diff = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                diff[i][j] = (2*rowSum[i] - m) + (2*colSum[j] - n);
            }
        }
        return diff;
    }
}