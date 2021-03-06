/**
 * 64. Minimum Path Sum
 * 
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */
public class No064 {

    public void run() {
        // Input
        int[][] grid = new int[][] { { 1, 2, 3 }, { 4, 5, 6 } };

        // Solution
        int result = minPathSum(grid);

        // Output
        System.out.println(result);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                } else if (i == 0 && j != 0) {
                    dp[0][j] = dp[0][j - 1] + grid[0][j];
                } else if (j == 0 && i != 0) {
                    dp[i][0] = dp[i - 1][0] + grid[i][0];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

}