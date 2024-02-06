/**
 * Problem: Group Anagrams
 * Description: Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> list;
            if(map.containsKey(sortedStr)) {
                list = map.get(sortedStr);
            } else {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(sortedStr, list);
        }
        List<List<String>> result = new ArrayList<>();
        for(String str: map.keySet()){
            result.add(map.get(str));
        }
        return result;
    }
}