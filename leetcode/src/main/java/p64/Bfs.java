package p64;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.LinkedList;

public class Bfs {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);

        var q = new LinkedList<Pair<Integer, Integer>>();
        q.addLast(new Pair<>(0, 0));
        dist[0][0] = grid[0][0];
        while (!q.isEmpty()) {
            Pair<Integer, Integer> current = q.removeFirst();

            Pair<Integer, Integer> next;
            // right
            if (current.getValue() + 1 < m) {
                next = new Pair<>(current.getKey(), current.getValue() + 1);
                if (dist[next.getKey()][next.getValue()] >
                        dist[current.getKey()][current.getValue()] + grid[next.getKey()][next.getValue()]) {
                    dist[next.getKey()][next.getValue()] = dist[current.getKey()][current.getValue()] + grid[next.getKey()][next.getValue()];
                    q.addLast(next);
                }
            }

            // down
            if (current.getKey() + 1 < n) {
                next = new Pair<>(current.getKey() + 1, current.getValue());
                if (dist[next.getKey()][next.getValue()] >
                        dist[current.getKey()][current.getValue()] + grid[next.getKey()][next.getValue()]) {
                    dist[next.getKey()][next.getValue()] = dist[current.getKey()][current.getValue()] + grid[next.getKey()][next.getValue()];
                    q.addLast(next);
                }
            }
        }

        return dist[n - 1][m - 1];
    }

    public static void main(String[] args) {
        var solution = new Bfs();
        int answer = solution.minPathSum(new int[][] {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        });
        System.out.println(answer);
    }
}
