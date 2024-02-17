/**
 * Problem: Minimum Window Substring
 * Description: Given two strings s and t of lengths m and n respectively, return the minimum window
 * substring
 *  of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *
 * The testcases will be generated such that the answer is unique.
 */
class Solution {
    public:
    string minWindow(string s, string t) {
        int n = s.length();
        map<char, int> mp;

        for(char &ch : t) {
            mp[ch]++;
        }

        int requiredCount = t.length();
        int i = 0, j  = 0;
        int minStart  = 0;
        int minWindow = INT_MAX;
        while(j < n) {
            char ch_j = s[j];
            if(mp[ch_j] > 0)
                requiredCount--;

            mp[ch_j]--;

            while(requiredCount == 0) {
                if(minWindow > j-i+1) {
                    minWindow = j-i+1;
                    minStart  = i;
                }

                char ch_i = s[i];
                mp[ch_i]++;
                if(mp[ch_i] > 0)
                    requiredCount++;
                i++;
            }

            j++;
        }

        return minWindow == INT_MAX ? "" : s.substr(minStart, minWindow);
    }
};