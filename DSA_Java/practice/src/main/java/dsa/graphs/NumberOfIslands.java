/*
Number of Islands
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent 
lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.
*/

/*
Loop through every cell
When you see '1' (land):
Increment island count
Run DFS/BFS to mark the entire island as visited (turn '1' → '0')

Time: O(m × n) → each cell visited once
Space: O(m × n) worst case (recursion stack or queue)

Use DFS when:
    Simpler code is preferred
    Grid is small
Use BFS when:
    Grid can be large (avoid stack overflow)
    You want iterative control
*/

/* DFS Solution */
package dsa.graphs;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public int numIslandsDFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        // boundary + water check
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
            return;
        }

        // mark visited
        grid[i][j] = '0';

        // explore neighbors
        dfs(grid, i + 1, j); // down
        dfs(grid, i - 1, j); // up
        dfs(grid, i, j + 1); // right
        dfs(grid, i, j - 1); // left
    }

    public int numIslandsBFS(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});

        // mark visited
        grid[i][j] = '0';

        int[][] directions = {
            {1, 0},  // down
            {-1, 0}, // up
            {0, 1},  // right
            {0, -1}  // left
        };

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();

            for (int[] dir : directions) {
                int newRow = cell[0] + dir[0];
                int newCol = cell[1] + dir[1];

                if (newRow >= 0 && newCol >= 0 &&
                    newRow < rows && newCol < cols &&
                    grid[newRow][newCol] == '1') {

                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0'; // mark visited
                }
            }
        }
    }
}