/**
 * Problem: Find Bottom Left Tree Value
 * Description: Given the root of a binary tree, return the leftmost value in the last row of the tree.
 */
class Solution {
    int result, l = 0;
    private void dfs(TreeNode root, int level) {
        if(root.left != null)
            dfs(root.left, level - 1);
        if(root.right != null) {
            dfs(root.right, level - 1);
        }
        if(level < l) {
            l = level;
            result = root.val;
        }
    }
    public int findBottomLeftValue(TreeNode root) {
        if(root.left == null && root.right == null)
            return root.val;

        dfs(root, 0);
        return result;
    }
}