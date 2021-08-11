/**
 * 931. Minimum Falling Path Sum
 * 
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col
 * - 1), (row + 1, col), or (row + 1, col + 1).
 */
public class No931 {

    public void run() {
        // Input
        int[][] matrix = new int[][] { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

        // Solution
        int result = minFallingPathSum(matrix);

        // Output
        System.out.println(result);
    }

    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }

        int[][] dp = new int[n][n];

        // first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j - 1 >= 0 && j + 1 < n) {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1])) + matrix[i][j];
                } else if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]) + matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + matrix[i][j];
                }

                if (i == n - 1) {
                    min = Math.min(min, dp[i][j]);
                }
            }
        }

        return min;
    }

}