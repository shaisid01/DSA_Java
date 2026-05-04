/* Clone Graph 
Given a reference of a node in a connected undirected graph.

Return a deep copy (clone) of the graph.

Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}
Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed). For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph. Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.
*/
/*
Whenever I see a node, I create its clone once, store it, and reuse.

Since the graph may contain cycles,use a HashMap to store already cloned nodes to avoid infinite recursion and duplication.
need a map:

Original Node → Cloned Node

to :
Prevent infinite loops (graphs can have cycles)
Ensure each node is cloned exactly once
Time: O(V + E)
Space: O(V) (map + recursion/queue)
*/

/*DFS Solution */
package dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}

public class CloneGraph {

    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraphDFS(Node node) {
        if (node == null) return null;

        // if already cloned, return it
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // clone current node
        Node clone = new Node(node.val);
        map.put(node, clone);

        // clone neighbors
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraphDFS(neighbor));
        }

        return clone;
    }

    public Node cloneGraphBFS(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.offer(node);
        map.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            for (Node neighbor : curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }
}