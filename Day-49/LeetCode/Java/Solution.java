/**
 * Problem: Climbing Stairs
 * Description: You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
class Solution {
    public int climbStairs(int n) {
        if(n <= 2)
            return n;

        int prev = 2, prevToPrev = 1, result = 0;
        while(n > 2) {
            result = prev + prevToPrev;
            prevToPrev = prev;
            prev = result;
            n--;
        }
        return result;
    }
}