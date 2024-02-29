/**
 * Problem: Even Odd Tree
 * Description: A binary tree is named Even-Odd if it meets the following conditions:
 *
 * The root of the binary tree is at level index 0, its children are at level index 1, their children are at level index 2, etc.
 * For every even-indexed level, all nodes at the level have odd integer values in strictly increasing order (from left to right).
 * For every odd-indexed level, all nodes at the level have even integer values in strictly decreasing order (from left to right).
 * Given the root of a binary tree, return true if the binary tree is Even-Odd, otherwise return false.
 */
class Solution {
    int[] arr = new int[100000];
    private boolean bfs(TreeNode root, int level) {
        if(root == null) return true;
        if(level % 2 == 0) {
            if(arr[level] < root.val && root.val % 2 != 0) {
                arr[level] = root.val;
            } else {
                return false;
            }
        } else {
            if((arr[level] > root.val || arr[level] == 0) && root.val % 2 == 0) {
                arr[level] = root.val;
            } else {
                return false;
            }
        }
        return bfs(root.left, level + 1) && bfs(root.right, level + 1);
    }
    public boolean isEvenOddTree(TreeNode root) {
        return bfs(root, 0);
    }
}