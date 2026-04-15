package dsa.BinaryTrees;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class MaximumDepthTest {

    @Test
    void testEmptyTree() {
        MaximumDepth.TreeNode root = null;

        assertEquals(0, MaximumDepth.maxDepth(root));
    }

    @Test
    void testSingleNode() {
        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(1);

        assertEquals(1, MaximumDepth.maxDepth(root));
    }

    @Test
    void testBalancedTree() {
        /*
                1
               / \
              2   3
        */
        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(1);
        root.left = new MaximumDepth.TreeNode(2);
        root.right = new MaximumDepth.TreeNode(3);

        assertEquals(2, MaximumDepth.maxDepth(root));
    }

    @Test
    void testLeftSkewedTree() {
        /*
            1
           /
          2
         /
        3
       /
      4
        */
        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(1);
        root.left = new MaximumDepth.TreeNode(2);
        root.left.left = new MaximumDepth.TreeNode(3);
        root.left.left.left = new MaximumDepth.TreeNode(4);

        assertEquals(4, MaximumDepth.maxDepth(root));
    }

    @Test
    void testRightSkewedTree() {
        /*
        1
         \
          2
           \
            3
        */
        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(1);
        root.right = new MaximumDepth.TreeNode(2);
        root.right.right = new MaximumDepth.TreeNode(3);

        assertEquals(3, MaximumDepth.maxDepth(root));
    }

    @Test
    void testComplexTree() {
        /*
                1
               / \
              2   3
             /
            4
             \
              5
        */
        MaximumDepth.TreeNode root = new MaximumDepth.TreeNode(1);
        root.left = new MaximumDepth.TreeNode(2);
        root.right = new MaximumDepth.TreeNode(3);
        root.left.left = new MaximumDepth.TreeNode(4);
        root.left.left.right = new MaximumDepth.TreeNode(5);

        assertEquals(4, MaximumDepth.maxDepth(root));
    }
}