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
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder out = new StringBuilder();
        Deque<Object> stack = new ArrayDeque<>();

        stack.push(root);

        while (!stack.isEmpty()) {
            Object current = stack.pop();

            if (current instanceof String) {
                out.append((String) current);
                continue;
            }

            TreeNode node = (TreeNode) current;
            out.append(node.val);

            if (node.right != null) {
                stack.push(")");
                stack.push(node.right);
                stack.push("(");
            }

            if (node.left != null) {
                stack.push(")");
                stack.push(node.left);
                stack.push("(");
            } else if (node.right != null) {
                stack.push("()");
            }
        }

        return out.toString();
    }
}
