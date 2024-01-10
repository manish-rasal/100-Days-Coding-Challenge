/**
 * Problem: Amount of Time for Binary Tree to Be Infected
 * Description: You are given the root of a binary tree with unique values, and an integer start. At minute 0, an infection starts from the node with value start.
 *
 * Each minute, a node becomes infected if:
 *
 * The node is currently uninfected.
 * The node is adjacent to an infected node.
 * Return the number of minutes needed for the entire tree to be infected.
 */
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) {
            return 0;
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraph(root, null, graph);

        return bfs(graph, start);
    }

    private void buildGraph(TreeNode node, TreeNode parent, Map<Integer, List<Integer>> graph) {
        if (node == null) {
            return;
        }

        graph.computeIfAbsent(node.val, k -> new ArrayList<>());
        if (parent != null) {
            graph.get(node.val).add(parent.val);
            graph.get(parent.val).add(node.val);
        }

        buildGraph(node.left, node, graph);
        buildGraph(node.right, node, graph);
    }

    private int bfs(Map<Integer, List<Integer>> graph, int start) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int neighbor : graph.getOrDefault(current, Collections.emptyList())) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            minutes++;
        }

        return minutes - 1;
    }
}