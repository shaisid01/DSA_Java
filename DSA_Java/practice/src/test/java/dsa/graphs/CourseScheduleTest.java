package dsa.graphs;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CourseScheduleTest {

    private final CourseSchedule solver = new CourseSchedule();

    @Test
    void testCanFinish() {
        // Simple valid chain: 0 <- 1
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};

        assertTrue(solver.canFinish(numCourses, prerequisites));
    }

    @Test
    void testCanFinishCycle() {
        // Cycle: 0 -> 1 -> 0
        int numCourses = 2;
        int[][] prerequisites = {{1, 0}, {0, 1}};

        assertFalse(solver.canFinish(numCourses, prerequisites));
    }

    @Test
    void testCanFinishSelfCycle() {
        // Course depends on itself
        int numCourses = 1;
        int[][] prerequisites = {{0, 0}};

        assertFalse(solver.canFinish(numCourses, prerequisites));
    }

    @Test
    void testCanFinishComplexDAG() {
        // 5 courses, valid DAG
        int numCourses = 5;
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2},
                {4, 3}
        };

        assertTrue(solver.canFinish(numCourses, prerequisites));
    }

    @Test
    void testCanFinishDisconnectedGraph() {
        // Two independent chains
        int numCourses = 6;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {4, 3},
                {5, 4}
        };

        assertTrue(solver.canFinish(numCourses, prerequisites));
    }

    @Test
    void testCanFinishBFS() {
        // Valid DAG (same logic but BFS version)
        int numCourses = 4;
        int[][] prerequisites = {
                {1, 0},
                {2, 1},
                {3, 2}
        };

        assertTrue(solver.canFinishBFS(numCourses, prerequisites));
    }

    @Test
    void testCanFinishBFSCycle() {
        // Cycle case for BFS
        int numCourses = 3;
        int[][] prerequisites = {
                {0, 1},
                {1, 2},
                {2, 0}
        };

        assertFalse(solver.canFinishBFS(numCourses, prerequisites));
    }
}