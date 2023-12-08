/**
 * Problem: Construct String from Binary Tree
 * Description: Given the root of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.
 *
 * Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        preorderTraversal(root, result);

        return result.toString();
    }

    private void preorderTraversal(TreeNode node, StringBuilder result) {
        if (node != null) {
            result.append(node.val);

            if (node.left != null || node.right != null) {
                result.append("(");
                preorderTraversal(node.left, result);
                result.append(")");

                if (node.right != null) {
                    result.append("(");
                    preorderTraversal(node.right, result);
                    result.append(")");
                }
            }
        }
    }
}