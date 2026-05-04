/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

 

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/

/*
classic cycle detection in a directed graph problem.

If there is a cycle, you cannot finish all courses → return false
If no cycle → return true

DFS cycle detection (clean)
BFS (Kahn’s Algorithm / Topological Sort)

*/

/* DFS Solution (Cycle Detection) 
Build adjacency list
Track:
visited → already fully processed
inStack → currently in recursion path
If we revisit a node in inStack → cycle exists

detect cycles in a directed graph using recursion stack tracking.
Time: O(V + E)
Space: O(V + E)
*/

package dsa.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] inStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(graph, i, visited, inStack)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph,
                             int node,
                             boolean[] visited,
                             boolean[] inStack) {

        visited[node] = true;
        inStack[node] = true;

        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (hasCycle(graph, nei, visited, inStack)) {
                    return true;
                }
            } else if (inStack[nei]) {
                return true; // cycle detected
            }
        }

        inStack[node] = false;
        return false;
    }

    /* BFS Solution (Kahn’s Algorithm / Topological Sort) 
        Compute indegree of each node
        Start with nodes having indegree = 0
        Remove edges gradually
        If we process all nodes → no cycle

        perform topological sorting; if I cannot process all nodes, a cycle exists.

        Time: O(V + E)
        Space: O(V + E)
    */

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {

    List<List<Integer>> graph = new ArrayList<>();
    int[] indegree = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
        graph.add(new ArrayList<>());
    }

    for (int[] pre : prerequisites) {
        int course = pre[0];
        int prereq = pre[1];
        graph.get(prereq).add(course);
        indegree[course]++;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < numCourses; i++) {
        if (indegree[i] == 0) {
            queue.offer(i);
        }
    }

    int count = 0;

    while (!queue.isEmpty()) {
        int curr = queue.poll();
        count++;

        for (int nei : graph.get(curr)) {
            indegree[nei]--;
            if (indegree[nei] == 0) {
                queue.offer(nei);
            }
        }
    }

    return count == numCourses;
}
}