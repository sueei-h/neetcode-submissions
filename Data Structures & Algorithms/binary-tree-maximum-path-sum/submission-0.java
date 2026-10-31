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
    public int maxPathSum(TreeNode root) {
        int[] out = { Integer.MIN_VALUE };
        dfs(root, out);
        return out[0];
    }

    private int dfs(TreeNode node, int[] out) {
        if (node == null) {
            return 0;
        }

        int left = Math.max(0, dfs(node.left, out));
        int right = Math.max(0, dfs(node.right, out));

        out[0] = Math.max(out[0], node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
