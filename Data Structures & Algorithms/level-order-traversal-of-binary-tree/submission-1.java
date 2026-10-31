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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        dfs(root, 0, out);
        return out;
    }

    private void dfs(TreeNode node, int depth, List<List<Integer>> out) {
        if (node == null) {
            return;
        }

        if (depth == out.size()) {
            out.add(new ArrayList<>());
        }

        out.get(depth).add(node.val);

        dfs(node.left, depth + 1, out);
        dfs(node.right, depth + 1, out);
    }
}
