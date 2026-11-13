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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    //think we track 2 booleans and the LCA
    //boolean 1 hasP and 2 hasQ
    public TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        //cases:
        //current node is between p.val and q.val- this is LCA
        //current node is < p and q- LCA in right tree
        //current node is > p and q- LCA in left tree
        TreeNode res = null;
        if (root.val > p.val && root.val > q.val) {
            res = dfs(root.left, p, q);
        }
        else if (root.val < p.val && root.val < q.val) {
            res = dfs(root.right, p, q);
        }
        else if ((root.val >= p.val && root.val <= q.val) ||
                 (root.val >= q.val && root.val <= p.val)) {
            return root;
        }
        return res;

    }
}
