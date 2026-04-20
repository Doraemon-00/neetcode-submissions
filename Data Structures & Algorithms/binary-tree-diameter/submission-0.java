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
    private int res;

    public int diameterOfBinaryTree(TreeNode root) {
        this.res = 0;
        dfs(root);

        return res;
    }

    private int dfs(TreeNode curr) {
        if (curr == null) return 0;

        int left = dfs(curr.left);
        int right = dfs(curr.right);

        res = Math.max(res, left + right);
        return 1 + Math.max(left, right);
    }
}
