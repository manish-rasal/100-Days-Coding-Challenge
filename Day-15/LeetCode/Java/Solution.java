/**
 * Problem: Destination City
 * Description: You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.
 *
 * It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.
 */
class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> destinations = new HashSet<>();

        for (List<String> path : paths) {
            destinations.add(path.get(1));
        }

        for (List<String> path : paths) {
            destinations.remove(path.get(0));
        }

        return destinations.iterator().next();
    }
}