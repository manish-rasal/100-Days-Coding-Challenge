/**
 * Problem: Image Smoother
 * Description: An image smoother is a filter of the size 3 x 3 that can be applied to each cell of an image by rounding down the average of the cell and the eight surrounding cells (i.e., the average of the nine cells in the blue smoother). If one or more of the surrounding cells of a cell is not present, we do not consider it in the average (i.e., the average of the four cells in the red smoother).
 * Given an m x n integer matrix img representing the grayscale of an image, return the image after applying the smoother on each cell of it.
 */
class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;
        int[][] result = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = smoothPixel(img, i, j);
            }
        }

        return result;
    }

    private int smoothPixel(int[][] img, int x, int y) {
        int sum = 0;
        int count = 0;

        for (int i = Math.max(0, x - 1); i <= Math.min(img.length - 1, x + 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(img[0].length - 1, y + 1); j++) {
                sum += img[i][j];
                count++;
            }
        }

        return sum / count;
    }
}