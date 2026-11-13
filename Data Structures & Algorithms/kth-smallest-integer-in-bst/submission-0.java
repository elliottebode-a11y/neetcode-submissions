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
    public int kthSmallest(TreeNode root, int k) {
        int[] tmp = new int[] {0, -1};
        dfs(root, tmp, k);
        return tmp[1];
    }

    public void dfs(TreeNode node, int[] tmp, int k) {
        if (node == null) return;

        dfs(node.left, tmp, k);

        if (tmp[0] == k) return;
        tmp[0] += 1;
        if (tmp[0] == k) {
            tmp[1] = node.val;
            return;
        }
        dfs(node.right, tmp, k);
    }
}
