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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE});
    }

    public boolean dfs(TreeNode node, int[] interval) {
        if (node == null) return true;

        if (interval[1] <= node.val || interval[0] >= node.val) {
            return false;
        }


        boolean left = dfs(node.left, new int[] {interval[0], node.val});
        boolean right = dfs(node.right, new int[] {node.val, interval[1]});

        return left && right;
    }
}
