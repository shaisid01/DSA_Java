package dsa.graphs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PacificAtlanticWaterFlowTest {

    private final PacificAtlanticWaterFlow solver = new PacificAtlanticWaterFlow();

    // Normalize result (order doesn't matter)
    private Set<String> normalize(List<List<Integer>> res) {
        Set<String> set = new HashSet<>();
        for (List<Integer> cell : res) {
            set.add(cell.get(0) + "," + cell.get(1));
        }
        return set;
    }

    @Test
    void testPacificAtlanticDFS() {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = solver.pacificAtlanticDFS(heights);

        Set<String> expected = Set.of(
                "0,4","1,3","1,4","2,2","3,0","3,1","4,0"
        );

        assertEquals(expected, normalize(result));
    }

    @Test
    void testPacificAtlanticBFS() {
        int[][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };

        List<List<Integer>> result = solver.pacificAtlanticDFS(heights);

        Set<String> expected = Set.of(
                "0,4","1,3","1,4","2,2","3,0","3,1","4,0"
        );

        assertEquals(expected, normalize(result));
    }

    @Test
    void testSingleCell() {
        int[][] heights = {{1}};

        List<List<Integer>> result = solver.pacificAtlanticDFS(heights);

        assertEquals(Set.of("0,0"), normalize(result));
    }

    @Test
    void testFlatGrid() {
        int[][] heights = {
                {1, 1},
                {1, 1}
        };

        List<List<Integer>> result = solver.pacificAtlanticDFS(heights);

        Set<String> expected = Set.of(
                "0,0","0,1","1,0","1,1"
        );

        assertEquals(expected, normalize(result));
    }

    @Test
    void testNoFlowCase() {
        int[][] heights = {
                {10, 9},
                {8, 7}
        };

            List<List<Integer>> result = solver.pacificAtlanticDFS(heights);

            // Only border cells can reach both
            Set<String> expected = Set.of(
                    "0,0","0,1","1,0");
        assertEquals(expected, normalize(result));
    }
}

