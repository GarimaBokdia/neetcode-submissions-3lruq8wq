class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int rows = heights.length;
        int cols = heights[0].length;

        // "Blue Flood" and "Red Flood" maps
        boolean[][] pacificReachable = new boolean[rows][cols];
        boolean[][] atlanticReachable = new boolean[rows][cols];

        // 1. Start the Floods from the Ocean Edges
        for (int i = 0; i < rows; i++) {
            // Pacific starts on Left Edge (col 0)
            dfs(heights, pacificReachable, i, 0, Integer.MIN_VALUE);
            // Atlantic starts on Right Edge (col cols-1)
            dfs(heights, atlanticReachable, i, cols - 1, Integer.MIN_VALUE);
        }
        for (int i = 0; i < cols; i++) {
            // Pacific starts on Top Edge (row 0)
            dfs(heights, pacificReachable, 0, i, Integer.MIN_VALUE);
            // Atlantic starts on Bottom Edge (row rows-1)
            dfs(heights, atlanticReachable, rows - 1, i, Integer.MIN_VALUE);
        }

        // 2. Find the "Purple" cells (Reachable by BOTH)
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }

    // The "Flooding" Logic
    private void dfs(int[][] heights, boolean[][] visited, int r, int c, int previousHeight) {
        // Stop if:
        // 1. Out of bounds
        // 2. Already flooded (visited)
        // 3. The wall is too low! Water can only climb UP equal or higher blocks.
        if (r < 0 || c < 0 || r >= heights.length || c >= heights[0].length || visited[r][c] || heights[r][c] < previousHeight) {
            return;
        }

        // Mark as flooded
        visited[r][c] = true;

        // Flood neighbors (Up, Down, Left, Right)
        dfs(heights, visited, r + 1, c, heights[r][c]);
        dfs(heights, visited, r - 1, c, heights[r][c]);
        dfs(heights, visited, r, c + 1, heights[r][c]);
        dfs(heights, visited, r, c - 1, heights[r][c]);
    }
}