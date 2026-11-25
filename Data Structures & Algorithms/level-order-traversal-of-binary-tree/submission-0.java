/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> out = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();

        if (root == null) {
            return out;
        }

        q.offer(root);

        while (!q.isEmpty()) {
            int n = q.size();
            List<Integer> in = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();

                in.add(node.val);

                if (node.left != null) {
                    q.offer(node.left);
                }

                if (node.right != null) {
                    q.offer(node.right);
                }
            }

            out.add(in);
        }

        return out;
    }
}
