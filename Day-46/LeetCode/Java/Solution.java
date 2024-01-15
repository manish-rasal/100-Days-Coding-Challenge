/**
 * Problem: Find Players With Zero or One Losses
 * Description: You are given an integer array matches where matches[i] = [winneri, loseri] indicates that the player winneri defeated player loseri in a match.
 *
 * Return a list answer of size 2 where:
 *
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 *
 * Note:
 *
 * You should only consider the players that have played at least one match.
 * The testcases will be generated such that no two matches will have the same outcome.
 */
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> winOrLose = new HashMap<>();
        for(int i = 0; i < matches.length; i++) {
            if(!winOrLose.containsKey(matches[i][0])) {
                winOrLose.put(matches[i][0], 0);
            }
            if(winOrLose.containsKey(matches[i][1])) {
                int val = winOrLose.get(matches[i][1]);
                winOrLose.put(matches[i][1], val + 1);
            } else {
                winOrLose.put(matches[i][1], 1);
            }
        }
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());
        for(int player: winOrLose.keySet()) {
            if(winOrLose.get(player) == 0){
                answer.get(0).add(player);
            }
            if(winOrLose.get(player) == 1){
                answer.get(1).add(player);
            }
        }
        for (List<Integer> innerList : answer) {
            Collections.sort(innerList);
        }
        return answer;
    }
}