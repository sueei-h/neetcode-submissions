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
        int[] count = { 0 };
        dfs(root, count, Integer.MIN_VALUE);
        return count[0];
    }

    public void dfs(TreeNode node, int[] count, int max) {
        if (node == null) {
            return;
        }

        if (node.val >= max) {
            max = node.val;
            count[0]++;
        }

        dfs(node.left, count, max);
        dfs(node.right, count, max);
    }
}
