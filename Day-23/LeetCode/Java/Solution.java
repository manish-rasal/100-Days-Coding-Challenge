/**
 * Problem: Path Crossing
 * Description: Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 *
 * Return true if the path crosses itself at any point, that is, if at any time you are on a location you have previously visited. Return false otherwise.
 */
class Solution {
    public boolean isPathCrossing(String path) {
        List<List<Integer>> visitedPoints = new ArrayList<>();
        List<Integer> currentPosition = new ArrayList<>(Arrays.asList(0, 0));
        visitedPoints.add(new ArrayList<>(Arrays.asList(0, 0)));
        for(int i = 0; i < path.length(); i++){
            if (path.charAt(i) == 'N')
                currentPosition.set(1, currentPosition.get(1) + 1);
            else if (path.charAt(i) == 'S')
                currentPosition.set(1, currentPosition.get(1) - 1);
            else if (path.charAt(i) == 'E')
                currentPosition.set(0, currentPosition.get(0) + 1);
            else if (path.charAt(i) == 'W')
                currentPosition.set(0, currentPosition.get(0) - 1);

            List<Integer> newPosition = new ArrayList<>(currentPosition);

            if (visitedPoints.contains(newPosition))
                return true;

            visitedPoints.add(newPosition);
        }
        return false;
    }
}