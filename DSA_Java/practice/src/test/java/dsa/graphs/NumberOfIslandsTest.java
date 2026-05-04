package dsa.graphs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class NumberOfIslandsTest {

    private final NumberOfIslands solver = new NumberOfIslands();
    
    // Helper to deep copy grid (since solution mutates input)
    private char[][] copyGrid(char[][] grid) {
        char[][] copy = new char[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            copy[i] = grid[i].clone();
        }
        return copy;
    }

    @Test
    void testEmptyGrid() {
        char[][] grid = {};
        assertEquals(0, solver.numIslandsDFS(grid));
        assertEquals(0, solver.numIslandsBFS(grid));
    }

    @Test
    void testSingleCellWater() {
        char[][] grid = {{'0'}};
        assertEquals(0, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(0, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testSingleCellLand() {
        char[][] grid = {{'1'}};
        assertEquals(1, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(1, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testAllWater() {
        char[][] grid = {
            {'0','0','0'},
            {'0','0','0'}
        };
        assertEquals(0, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(0, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testAllLand() {
        char[][] grid = {
            {'1','1'},
            {'1','1'}
        };
        assertEquals(1, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(1, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testMultipleIslands() {
        char[][] grid = {
            {'1','1','0','0'},
            {'1','0','0','1'},
            {'0','0','1','1'},
            {'0','0','0','0'}
        };

        assertEquals(2, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(2, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testDiagonalNotConnected() {
        char[][] grid = {
            {'1','0','1'},
            {'0','1','0'},
            {'1','0','1'}
        };
        // diagonals don't count → 5 islands
        assertEquals(5, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(5, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testSingleRow() {
        char[][] grid = {
            {'1','0','1','1','0','1'}
        };
        assertEquals(3, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(3, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testSingleColumn() {
        char[][] grid = {
            {'1'},
            {'0'},
            {'1'},
            {'1'},
            {'0'},
            {'1'}
        };
        assertEquals(3, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(3, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testComplexShape() {
        char[][] grid = {
            {'1','1','0','1'},
            {'1','0','0','1'},
            {'0','0','1','0'},
            {'1','1','0','0'}
        };
        assertEquals(4, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(4, solver.numIslandsBFS(copyGrid(grid)));
    }

    @Test
    void testLargeConnectedIsland() {
        char[][] grid = {
            {'1','1','1','1','1'},
            {'1','1','1','1','1'},
            {'1','1','1','1','1'}
        };
        assertEquals(1, solver.numIslandsDFS(copyGrid(grid)));
        assertEquals(1, solver.numIslandsBFS(copyGrid(grid)));
    }
}