/*417. Pacific Atlantic Water Flow

There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean. The Pacific Ocean touches the island's left and top edges, and the Atlantic Ocean touches the island's right and bottom edges.

The island is partitioned into a grid of square cells. You are given an m x n integer matrix heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).

The island receives a lot of rain, and the rain water can flow to neighboring cells directly north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height. Water can flow from any cell adjacent to an ocean into the ocean.

Return a 2D list of grid coordinates result where result[i] = [ri, ci] denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
*/
/*
Instead of:
“From each cell, can water reach oceans?”
flip it:
Start from oceans and see where water can flow in reverse (only uphill or equal height)
Why?
Much more efficient
Avoids repeated work from every cell

Pacific Ocean sources:
    Top row
    Left column
Atlantic Ocean sources:
    Bottom row
    Right column

Flow rule (reversed):
From a cell (r, c) you can go to neighbor (nr, nc) if:
heights[nr][nc] >= heights[r][c]
(because water flows downhill, so reverse is uphill/equal)

Final
Run DFS/BFS from Pacific → mark reachable cells
Run DFS/BFS from Atlantic → mark reachable cells
Intersection = answer
*/

/* Java DFS Solution
Instead of simulating water flow from every cell, reverse the process: 
start from both oceans and mark all cells that can reach them using DFS. 
The intersection gives cells that can reach both oceans.
Time: O(m × n) (each cell visited at most twice)
Space: O(m × n) (visited arrays + recursion stack)
*/
package dsa.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {

    private int rows, cols;

    public List<List<Integer>> pacificAtlanticDFS(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        if (heights == null || heights.length == 0) return result;

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        // Pacific: top row + left column
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, 0, j, pacific);
        }

        // Atlantic: bottom row + right column
        for (int i = 0; i < rows; i++) {
            dfs(heights, i, cols - 1, atlantic);
        }
        for (int j = 0; j < cols; j++) {
            dfs(heights, rows - 1, j, atlantic);
        }

        // intersection
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] d : dirs) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
            if (visited[nr][nc]) continue;

            if (heights[nr][nc] >= heights[r][c]) {
                dfs(heights, nr, nc, visited);
            }
        }
    }

    /* BFS Approach
    Instead of flowing water from cells → oceans,  do:
    Start from Pacific + Atlantic borders and expand inward (only to equal or higher heights)
    */
          public List<List<Integer>> pacificAtlanticBFS(int[][] heights) {
            List<List<Integer>> result = new ArrayList<>();
            if (heights == null || heights.length == 0) return result;

            int rows = heights.length;
            int cols = heights[0].length;

            boolean[][] pacific = bfs(heights, rows, cols, true);
            boolean[][] atlantic = bfs(heights, rows, cols, false);

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (pacific[r][c] && atlantic[r][c]) {
                        result.add(Arrays.asList(r, c));
                    }
                }
            }

            return result;
        }

        private boolean[][] bfs(int[][] heights, int rows, int cols, boolean isPacific) {
            boolean[][] visited = new boolean[rows][cols];
            Queue<int[]> queue = new LinkedList<>();

            // Initialize queue with border cells
            if (isPacific) {
                for (int r = 0; r < rows; r++) {
                    queue.offer(new int[]{r, 0}); // left edge
                    visited[r][0] = true;
                }
                for (int c = 0; c < cols; c++) {
                    queue.offer(new int[]{0, c}); // top edge
                    visited[0][c] = true;
                }
            } else {
                for (int r = 0; r < rows; r++) {
                    queue.offer(new int[]{r, cols - 1}); // right edge
                    visited[r][cols - 1] = true;
                }
                for (int c = 0; c < cols; c++) {
                    queue.offer(new int[]{rows - 1, c}); // bottom edge
                    visited[rows - 1][c] = true;
                }
            }

            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

            while (!queue.isEmpty()) {
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for (int[] d : dirs) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr < 0 || nc < 0 || nr >= rows || nc >= cols) continue;
                    if (visited[nr][nc]) continue;

                    // reverse flow condition (can only go uphill or same height)
                    if (heights[nr][nc] >= heights[r][c]) {
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }

            return visited;
        }
    }
