/**
 * Problem: Buy Two Chocolates
 * Description: You are given an integer array prices representing the prices of various chocolates in a store. You are also given a single integer money, which represents your initial amount of money.
 *
 * You must buy exactly two chocolates in such a way that you still have some non-negative leftover money. You would like to minimize the sum of the prices of the two chocolates you buy.
 *
 * Return the amount of money you will have leftover after buying the two chocolates. If there is no way for you to buy two chocolates without ending up in debt, return money. Note that the leftover must be non-negative.
 */
class Solution {
    public int buyChoco(int[] prices, int money) {
        int small = 101, secondSmall = 101, n = prices.length;
        for(int i = 0; i < n; i++) {
            if(prices[i] <= small) {
                secondSmall = small;
                small = prices[i];
            }
            if(prices[i] > small && prices[i] <= secondSmall)
                secondSmall = prices[i];
        }
        return (money >= (small + secondSmall))? (money - (small + secondSmall)) : money;
    }
}