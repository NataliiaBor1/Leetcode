class Solution {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == 1) {
                        perimeter += 4; // Add 4 for each land cell

                        // Check adjacent cells
                        if (i > 0 && grid[i - 1][j] == 1) // Up
                            perimeter -= 2;
                        if (j > 0 && grid[i][j - 1] == 1) // Left
                            perimeter -= 2;
                    }
                }
            }

            return perimeter;
    }
}