package p221;

public class DP {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = (n == 0)? 0 : matrix[0].length;
        int[][] memo = new int[n][m];

        int maxSquareHeight = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        memo[i][j] = 1;
                        maxSquareHeight = Math.max(maxSquareHeight, memo[i][j]);
                        continue;
                    }

                    memo[i][j] = Math.min(Math.min(memo[i-1][j],memo[i][j-1]), memo[i-1][j-1]) + 1;
                    maxSquareHeight = Math.max(maxSquareHeight, memo[i][j]);
                }
            }
        }

        return maxSquareHeight * maxSquareHeight;
    }
}
