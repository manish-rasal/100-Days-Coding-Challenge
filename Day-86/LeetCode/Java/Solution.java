/**
 * Problem: Find All People With Secret
 * Description: You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.
 *
 * Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
 *
 * The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.
 *
 * Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.
 */
class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int person1 = meeting[0];
            int person2 = meeting[1];
            int time    = meeting[2];
            graph.computeIfAbsent(person2, k -> new ArrayList<>()).add(new int[]{time, person1});
            graph.computeIfAbsent(person1, k -> new ArrayList<>()).add(new int[]{time, person2});
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});
        pq.offer(new int[]{0, firstPerson});

        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            int[] timePerson = pq.poll();
            int time = timePerson[0], person = timePerson[1];
            if (visited[person]) {
                continue;
            }
            visited[person] = true;
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextPersonTime[0], nextPerson = nextPersonTime[1];
                if (!visited[nextPerson] && t >= time) {
                    pq.offer(new int[]{t, nextPerson});
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (visited[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
}