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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        return dfs1(root, subRoot);
    }

    public boolean dfs1(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        boolean check = false;
        if (root.val == subRoot.val && dfs2(root, subRoot)) {
            return true;
        }
        return dfs1(root.left, subRoot) || dfs1(root.right, subRoot);
    }

    public boolean dfs2(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;
        if (root == null || subRoot == null) return false;

        if (root.val != subRoot.val) return false;

        return dfs2(root.left, subRoot.left) && dfs2(root.right, subRoot.right);
    }
}
