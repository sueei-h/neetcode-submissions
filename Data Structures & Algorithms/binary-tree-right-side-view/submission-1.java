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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> out = new ArrayList<>();

        if (root == null) {
            return out;
        }

        dfs(root, 0, out);

        return out;
    }

    public void dfs(TreeNode node, int depth, List<Integer> out) {
        if (node == null) {
            return;
        }

        if (depth == out.size()) {
            out.add(node.val);
        }

        dfs(node.right, depth + 1, out);
        dfs(node.left, depth + 1, out);
    }
}
