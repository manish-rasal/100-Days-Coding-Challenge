/**
 * Problem: Diameter of Binary Tree
 * Description: Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
class Solution {
    int diameter = 0;
    private void dfs(TreeNode root) {
        int leftHeight = 0, rightHeight = 0;
        leftHeight = height(root.left);
        rightHeight = height(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        if(root.left != null)
            dfs(root.left);
        if(root.right != null)
            dfs(root.right);
    }

    private int height(TreeNode root) {
        if(root == null)
            return 0;
        if(root.right == null && root.left == null)
            return 1;
        else if(root.right == null)
            return 1 + height(root.left);
        else if(root.left == null)
            return 1 + height(root.right);
        else
            return 1 + Math.max(height(root.right), height(root.left));

    }
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }
}