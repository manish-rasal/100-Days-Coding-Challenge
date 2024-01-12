/**
 * Problem: Determine if String Halves Are Alike
 * Description: You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.
 *
 * Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.
 *
 * Return true if a and b are alike. Otherwise, return false.
 */
class Solution {
    String vowels = "aeiouAEIOU";
    public boolean halvesAreAlike(String s) {
        int countOfVowels = 0;
        int n = s.length();
        for(int i = 0; i < n/2; i++) {
            if(vowels.indexOf(s.charAt(i)) != -1)
                countOfVowels++;
            if(vowels.indexOf(s.charAt(i + n/2)) != -1)
                countOfVowels--;
        }
        return countOfVowels == 0;
    }
}