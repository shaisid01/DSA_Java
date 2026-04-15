package dsa.LinkedListStackQueue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class BFSLevelOrderTraversalTest {

    @Test
    void testLevelOrder() {

        /*
                1
               / \
              2   3
             / \
            4   5
        */

        BFSLevelOrderTraversal.TreeNode root =
                new BFSLevelOrderTraversal.TreeNode(1);

        root.left = new BFSLevelOrderTraversal.TreeNode(2);
        root.right = new BFSLevelOrderTraversal.TreeNode(3);
        root.left.left = new BFSLevelOrderTraversal.TreeNode(4);
        root.left.right = new BFSLevelOrderTraversal.TreeNode(5);

        List<List<Integer>> result =
                BFSLevelOrderTraversal.levelOrder(root);

        assertEquals(3, result.size());

        assertEquals(List.of(1), result.get(0));
        assertEquals(List.of(2, 3), result.get(1));
        assertEquals(List.of(4, 5), result.get(2));
    }

    @Test
    void testEmptyTree() {
        assertTrue(BFSLevelOrderTraversal.levelOrder(null).isEmpty());
    }

    @Test
    void testSingleNode() {
        BFSLevelOrderTraversal.TreeNode root =
                new BFSLevelOrderTraversal.TreeNode(1);

        List<List<Integer>> result =
                BFSLevelOrderTraversal.levelOrder(root);

        assertEquals(1, result.size());
        assertEquals(List.of(1), result.get(0));
    }

    @Test
    void testRightSkewedTree() {

        BFSLevelOrderTraversal.TreeNode root =
                new BFSLevelOrderTraversal.TreeNode(1);

        root.right = new BFSLevelOrderTraversal.TreeNode(2);
        root.right.right = new BFSLevelOrderTraversal.TreeNode(3);

        List<List<Integer>> result =
                BFSLevelOrderTraversal.levelOrder(root);

        assertEquals(List.of(
                List.of(1),
                List.of(2),
                List.of(3)
        ), result);
    }
}
