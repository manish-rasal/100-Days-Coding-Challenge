/**
 * Problem: Calculate Money in Leetcode Bank
 * Description: Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
 *
 * He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
 * Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.
 */
class Solution {
    public int totalMoney(int n) {
        int fullWeeks = n / 7;
        int remainingDays = n % 7;

        int totalMoneyFullWeeks = 28 * fullWeeks + 7 * (fullWeeks * (fullWeeks - 1)) / 2;
        int totalMoneyRemainingDays = remainingDays * (fullWeeks + 1) + (remainingDays * (remainingDays - 1)) / 2;

        return totalMoneyFullWeeks + totalMoneyRemainingDays;
    }
}