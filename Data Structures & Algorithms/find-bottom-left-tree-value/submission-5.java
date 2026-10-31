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
    public int findBottomLeftValue(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        Deque<Integer> depths = new ArrayDeque<>();

        stack.push(root);
        depths.push(0);

        int maxDepth = -1;
        int answer = root.val;

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            int depth = depths.pop();

            if (depth > maxDepth) {
                maxDepth = depth;
                answer = node.val;
            }

            if (node.right != null) {
                stack.push(node.right);
                depths.push(depth + 1);
            }

            if (node.left != null) {
                stack.push(node.left);
                depths.push(depth + 1);
            }
        }

        return answer;
    }
}
