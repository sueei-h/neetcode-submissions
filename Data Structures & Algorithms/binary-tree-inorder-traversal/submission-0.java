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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> out = new ArrayList<>();
        
        if (root == null) {
            return out;
        }

        dfs(root, out);
        
        return out;
    }

    public void dfs(TreeNode root, List<Integer> out) {
        if (root == null) {
            return;
        }

        dfs(root.left, out);
        out.add(root.val);
        dfs(root.right, out);
    }
}