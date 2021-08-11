/**
 * 221. Maximal Square
 * 
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 */
public class No221 {

    public void run() {
        // Input
        char[][] matrix = new char[][] { 
            { '1', '0', '1', '0', '0' }, 
            { '1', '0', '1', '1', '1' }, 
            { '1', '1', '1', '1', '1' }, 
            { '1', '0', '0', '1', '0' } 
        };

        // Solution
        int result = maximalSquare(matrix);

        // Output
        System.out.println(result);
    }

    public int maximalSquare(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1) {
            for (int i = 0; i < n; i++) {
                char c = matrix[0][i];
                if (c == '1') {
                    return 1;
                }
            }
        }

        if (n == 1) {
            for (int i = 0; i < m; i++) {
                char c = matrix[i][0];
                if (c == '1') {
                    return 1;
                }
            }
        }

        int[][] dp = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(dp[i][0], max);
        }

        for (int j = 1; j < n; j++) {
            dp[0][j] = matrix[0][j] == '1' ? 1 : 0;
            max = Math.max(dp[0][j], max);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        return (int) Math.pow(max, 2);

    }

}
