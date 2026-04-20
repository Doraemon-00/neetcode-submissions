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
    public int goodNodes(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, Integer.MIN_VALUE));
        
        while(!q.isEmpty()) {
            Pair<TreeNode, Integer> pair =  q.poll();
            TreeNode curr = pair.getKey();
            int maxVal = pair.getValue();

            if (curr.val >= maxVal) res++;
            if (curr.left != null) {
                q.offer(new Pair<>(curr.left, Math.max(curr.val, maxVal)));
            }
            if (curr.right != null) {
                q.offer(new Pair<>(curr.right, Math.max(curr.val, maxVal)));
            }
        }

        return res;
    }
}
