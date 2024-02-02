/**
 * Problem: Sequential Digits
 * Description: An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
 *
 * Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 */
class Solution {

    public int sequentialNum(int n, int low) {
        int digit = n % 10;
        n = n * 10 + digit + 1;
        if(digit != 9) {
            if(n < low)
                return sequentialNum(n, low);
            return n;
        }
        return 0;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < 10; i++) {
            int seq = i;
            while(seq != 0){
                seq = sequentialNum(seq, low);
                if(seq >= low && seq <= high)
                    ans.add(seq);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}