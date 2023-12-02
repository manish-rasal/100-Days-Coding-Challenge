/**
 * Problem: Find Words That Can Be Formed by Characters
 * Description: You are given an array of strings words and a string chars.
 *              A string is good if it can be formed by characters from chars (each character can only be used once).
 *              Return the sum of lengths of all good strings in words.
 */
class Solution {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> charCountMap = countChars(chars);

        for (String word : words) {
            Map<Character, Integer> wordCountMap = countChars(word);
            if (canFormWord(wordCountMap, charCountMap)) {
                result += word.length();
            }
        }

        return result;
    }

    private Map<Character, Integer> countChars(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        return charCountMap;
    }

    private boolean canFormWord(Map<Character, Integer> wordCountMap, Map<Character, Integer> charCountMap) {
        for (Map.Entry<Character, Integer> entry : wordCountMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (!charCountMap.containsKey(c) || charCountMap.get(c) < count) {
                return false;
            }
        }
        return true;
    }
}