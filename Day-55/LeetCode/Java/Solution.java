/**
 * Problem: Pseudo-Palindromic Paths in a Binary Tree
 * Description: Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 *
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 */
class Solution {
    private int result = 0;

    public int pseudoPalindromicPaths(TreeNode root) {
        solve(root, 0);
        return result;
    }

    private void solve(TreeNode root, int temp) {
        if (root != null) {
            temp = temp ^ (1 << root.val);

            if (root.left == null && root.right == null) {
                if ((temp & (temp - 1)) == 0) {
                    result++;
                }
            }

            solve(root.left, temp);
            solve(root.right, temp);
        }
    }
}