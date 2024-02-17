/**
 * Problem: Least Number of Unique Integers after K Removals
 * Description: Given an array of integers arr and an integer k. Find the least number of unique integers after removing exactly k elements.
 */
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        int n = list.size();
        if(k == 0)
            return n;
        for(int i = 0; i < n; i++) {
            if(k < list.get(i).getValue())
                return n - i;
            else
                k = k - list.get(i).getValue();
        }
        return 0;
    }
}