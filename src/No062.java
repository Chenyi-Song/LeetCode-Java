/**
 * 62. Unique Paths
 * 
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 */
public class No062 {

    public void run() {
        // Input
        int m = 3, n = 7;

        // Solution
        int result = uniquePaths(m, n);

        // Output
        System.out.println(result);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = j + 1;
        }

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = i + 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

}
