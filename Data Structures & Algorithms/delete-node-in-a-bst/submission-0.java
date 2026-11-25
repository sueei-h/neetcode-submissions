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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        int cmp = Integer.compare(key, root.val);

        if (cmp < 0) {
            root.left = deleteNode(root.left, key);
        } else if (cmp > 0) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            TreeNode temp = root;
            root = min(temp.right);
            root.right = deleteMin(temp.right);
            root.left = temp.left;
        }

        return root;
    }

    private TreeNode deleteMin(TreeNode node) {
        if (node.left == null) {
            return node.right;
        }

        node.left = deleteMin(node.left);

        return node;
    }

    private TreeNode min(TreeNode node) {
        if (node.left == null) {
            return node;
        }

        return min(node.left);
    }
}