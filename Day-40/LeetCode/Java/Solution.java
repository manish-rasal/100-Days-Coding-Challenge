/**
 * Problem: Leaf-Similar Trees
 * Description: Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
class Solution {
    List<Integer> leaves = new ArrayList<>();
    public void traverse(TreeNode root) {
        if(root.left != null)
            traverse(root.left);
        if(root.left == null && root.right == null)
            leaves.add(root.val);
        if(root.right != null)
            traverse(root.right);

    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        traverse(root1);
        int n1 = leaves.size();
        traverse(root2);
        int n2 = leaves.size();
        return leaves.subList(0, n1).equals(leaves.subList(n1, n2));
    }
}