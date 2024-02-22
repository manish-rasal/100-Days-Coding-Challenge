/**
 * Problem: Find the Town Judge
 * Description: In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 */
class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n - 1 > trust.length)
            return -1;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int[] i: trust) {
            map.computeIfAbsent(i[1], k -> new ArrayList<>()).add(i[0]);
        }
        int judge = 1;
        for(int i: map.keySet()){
            if(map.get(i).size() == n - 1)
                judge = i;
        }
        for(List<Integer> i: map.values()){
            if(i.indexOf(judge) != -1)
                return -1;
        }
        return judge;
    }
}