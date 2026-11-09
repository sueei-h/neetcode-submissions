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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> out = new ArrayList<>();

		if (root == null) {
			return out;
		}

		Deque<TreeNode> q = new ArrayDeque<>();
		boolean isLeftToRight = true;

		q.offer(root);

		while (!q.isEmpty()) {
			int n = q.size();
			List<Integer> currLevel = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				TreeNode currNode = q.poll();

				if (isLeftToRight) {
					currLevel.addLast(currNode.val);
				} else {
					currLevel.addFirst(currNode.val);
				}

				if (currNode.left != null) {
					q.offer(currNode.left);
				}

				if (currNode.right != null) {
					q.offer(currNode.right);
				}
			}

			out.add(currLevel);

			isLeftToRight = !isLeftToRight;
		}

		return out;
	}
}