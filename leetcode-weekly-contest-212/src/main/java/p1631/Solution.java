package p1631;

import java.util.*;

public class Solution {
    int[][] DIRECTIONS = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] minEffort = new int[rows][cols];
        for (int[] line : minEffort) Arrays.fill(line, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        minEffort[0][0] = 0;
        while (!q.isEmpty()) {
            int[] elem = q.poll();
            int currentRow = elem[0];
            int currentCol = elem[1];
            int currentMaxEffort = elem[2];

            for (int[] direction : DIRECTIONS) {
                int nextRow = currentRow + direction[0];
                int nextCol = currentCol + direction[1];
                if (nextRow < 0 || nextRow > rows - 1 || nextCol < 0 || nextCol > cols - 1) continue;

                int effort = Math.abs(heights[currentRow][currentCol] - heights[nextRow][nextCol]);
                int newMaxEffort = Math.max(currentMaxEffort, effort);
                if (newMaxEffort < minEffort[nextRow][nextCol]) {
                    minEffort[nextRow][nextCol] = newMaxEffort;
                    q.offer(new int[]{nextRow, nextCol, newMaxEffort});
                }
            }
        }
        return minEffort[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumEffortPath(new int[][]{
                {1,2,2},
                {3,8,2},
                {5,3,5}
        });
    }
}
