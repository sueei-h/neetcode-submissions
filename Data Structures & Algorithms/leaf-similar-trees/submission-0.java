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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> out1 = new ArrayList<>();
        List<Integer> out2 = new ArrayList<>();

        dfs(root1, out1);
        dfs(root2, out2);

        return out1.equals(out2);
    }

    public void dfs(TreeNode node, List<Integer> out) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            out.add(node.val);
        }

        dfs(node.left, out);
        dfs(node.right, out);
    }
}
