/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

recursive - Because each node contributes 1 + the maximum depth of its subtrees, forming a natural divide-and-conquer structure.
The max depth of a tree is:
1 + max(depth of left subtree, depth of right subtree)

Time	O(n)
Space	O(h) recursion stack (h = height)
*/

package dsa.BinaryTrees;

public class MaximumDepth {

     static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
