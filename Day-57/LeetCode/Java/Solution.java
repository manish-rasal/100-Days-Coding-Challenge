/**
 * Problem: Out of Boundary Paths
 * Description: There is an m x n grid with a ball. The ball is initially at the position [startRow, startColumn]. You are allowed to move the ball to one of the four adjacent cells in the grid (possibly out of the grid crossing the grid boundary). You can apply at most maxMove moves to the ball.
 *
 * Given the five integers m, n, maxMove, startRow, startColumn, return the number of paths to move the ball out of the grid boundary. Since the answer can be very large, return it modulo 109 + 7.
 */
class Solution {
    int MOD = 1000000007;
    int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] t = new int[50][50];
        t[startRow][startColumn] = 1;
        int result = 0;

        for (int k = 1; k <= maxMove; ++k) {
            int[][] temp = new int[50][50];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {

                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x < 0 || x >= m || y < 0 || y >= n) {
                            result = (result + t[i][j]) % MOD;
                        } else {
                            temp[x][y] = (temp[x][y] + t[i][j]) % MOD;
                        }
                    }
                }
            }
            t = Arrays.copyOf(temp, temp.length);
        }

        return result;
    }
}