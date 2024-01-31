/**
 * Problem: Daily Temperatures
 * Description: Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.add(n - 1);
        for(int i = n - 2; i >= 0; i--) {
            while(!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }
            if(stack.empty())
                ans[i] = 0;
            else
                ans[i] = stack.peek() - i;
            stack.add(i);
        }
        return ans;
    }
}