/**
 * Problem: Maximum Difference Between Node and Ancestor
 * Description: Given the root of a binary tree, find the maximum value v for which there exist different nodes a and b where v = |a.val - b.val| and a is an ancestor of b.
 *
 * A node a is an ancestor of b if either: any child of a is equal to b or any child of a is an ancestor of b.
 */
class Solution {
    private int dfs(TreeNode node, int minVal, int maxVal) {
        if (node == null) {
            return maxVal - minVal;
        }

        minVal = Math.min(minVal, node.val);
        maxVal = Math.max(maxVal, node.val);

        int leftDiff = dfs(node.left, minVal, maxVal);
        int rightDiff = dfs(node.right, minVal, maxVal);

        return Math.max(leftDiff, rightDiff);
    }
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }
}