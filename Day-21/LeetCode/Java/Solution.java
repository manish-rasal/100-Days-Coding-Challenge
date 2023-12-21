/**
 * Problem: Widest Vertical Area Between Two Points Containing No Points
 * Description: Given n points on a 2D plane where points[i] = [xi, yi], Return the widest vertical area between two points such that no points are inside the area.
 *
 * A vertical area is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The widest vertical area is the one with the maximum width.
 *
 * Note that points on the edge of a vertical area are not considered included in the area.
 */
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(point -> point[0]));
        int diff = 0;
        for(int i = 1; i < points.length; i++) {
            diff = Math.max((points[i][0] - points[i - 1][0]), diff);
        }
        return diff;
    }
}