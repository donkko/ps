package p1254;

import java.util.ArrayList;

public class Solution {
    private int n, m;
    private boolean[][] visited;
    int[][] d = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int[][] g;

    public int closedIsland(int[][] grid) {
        g = grid;
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] > 0 || visited[i][j]) continue;

                visited[i][j] = true;
                boolean isIsland = search(i, j);
                if (isIsland) answer++;
            }
        }
        return answer;
    }

    private boolean search(int ci, int cj) {
        visited[ci][cj] = true;
        boolean isIsland = true;
        for (int idx = 0; idx < 4; idx++) {
            int ni = ci + d[idx][0];
            int nj = cj + d[idx][1];


            if (ni < 0 || ni >= n || nj < 0 || nj >= m) {
                isIsland = false;
                continue;
            } else if (visited[ni][nj] || g[ni][nj] > 0) {
                continue;
            } else {
                return search(ni, nj);
            }
        }
        return isIsland;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
