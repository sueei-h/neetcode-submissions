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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] out = { Integer.MIN_VALUE };
        dfs(root, out);
        return out[0];
    }

    private int dfs(TreeNode node, int[] out) {
        if (node == null) {
            return -1;
        }

        int left = dfs(node.left, out);
        int right = dfs(node.right, out);

        out[0] = Math.max(out[0], 2 + left + right);

        return 1 + Math.max(left, right);
    }
}
