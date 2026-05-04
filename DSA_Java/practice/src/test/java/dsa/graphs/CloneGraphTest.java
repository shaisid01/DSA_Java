package dsa.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

public class CloneGraphTest {

    private final CloneGraph solver = new CloneGraph();

    // Build graph from adjacency list
    private Node buildGraph(int[][] adj) {
        if (adj.length == 0) return null;

        Map<Integer, Node> map = new HashMap<>();

        for (int i = 1; i <= adj.length; i++) {
            map.put(i, new Node(i));
        }

        for (int i = 0; i < adj.length; i++) {
            Node node = map.get(i + 1);
            for (int nei : adj[i]) {
                node.neighbors.add(map.get(nei));
            }
        }

        return map.get(1);
    }

    // Validate deep copy (structure + values + no shared references)
    private void assertSameStructure(Node original, Node clone) {
        assertNotNull(clone);
        assertNotSame(original, clone);

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        q.add(original);
        visited.put(original, clone);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            Node clonedCurr = visited.get(curr);

            assertEquals(curr.val, clonedCurr.val);
            assertEquals(curr.neighbors.size(), clonedCurr.neighbors.size());

            for (int i = 0; i < curr.neighbors.size(); i++) {
                Node origNei = curr.neighbors.get(i);
                Node cloneNei = clonedCurr.neighbors.get(i);

                assertNotSame(origNei, cloneNei);

                if (!visited.containsKey(origNei)) {
                    visited.put(origNei, cloneNei);
                    q.add(origNei);
                }
            }
        }
    }

    @Test
    void testCloneGraphDFS() {
        int[][] adj = {
                {2, 4},
                {1, 3},
                {2, 4},
                {1, 3}
        };

        Node original = buildGraph(adj);
        Node cloned = solver.cloneGraphDFS(original);

        assertSameStructure(original, cloned);
    }

    @Test
    void testCloneGraphBFS() {
        int[][] adj = {
                {2, 3},
                {1, 4},
                {1, 4},
                {2, 3}
        };

        Node original = buildGraph(adj);
        Node cloned = solver.cloneGraphBFS(original);

        assertSameStructure(original, cloned);
    }

    @Test
    void testSingleNode() {
        Node n = new Node(1);

        assertSameStructure(n, solver.cloneGraphDFS(n));
        assertSameStructure(n, solver.cloneGraphBFS(n));
    }

    @Test
    void testNull() {
        assertNull(solver.cloneGraphDFS(null));
        assertNull(solver.cloneGraphBFS(null));
    }
}