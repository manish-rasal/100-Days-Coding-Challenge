/**
 * Problem: Sort Characters By Frequency
 * Description: Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.
 *
 * Return the sorted string. If there are multiple answers, return any of them.
 */
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                int val = map.get(s.charAt(i));
                map.put(s.charAt(i), val + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        String result = "";
        for(Map.Entry<Character, Integer> e: list){
            int val = e.getValue();
            while(val > 0){
                result += e.getKey();
                val -= 1;
            }

        }
        return result;
    }
}