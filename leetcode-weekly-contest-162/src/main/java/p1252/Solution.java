package p1252;

public class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] index : indices) {
            int rowToApply = index[0];
            int columnToApply = index[1];

            for (int idx = 0; idx < n; idx++) matrix[idx][columnToApply]++;
            for (int idx = 0; idx < m; idx++) matrix[rowToApply][idx]++;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] % 2 == 1) answer++;
            }
        }
        return answer;
    }
}
