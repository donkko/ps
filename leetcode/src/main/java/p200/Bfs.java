package p200;

import javafx.util.Pair;

import java.util.LinkedList;

public class Bfs {
    public int numIslands(char[][] grid) {
        var h = grid.length;
        if (h == 0) return 0;
        var w = grid[0].length;
        if (w == 0) return 0;

        var discovered = new boolean[h][w];
        var queue = new LinkedList<Pair<Integer, Integer>>();
        var answer = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (discovered[i][j]) {
                    continue;
                }

                discovered[i][j] = true;
                if (grid[i][j] == '0') continue;
                answer++;
                queue.addLast(new Pair(i, j));
                while (!queue.isEmpty()) {
                    var node = queue.removeFirst();
                    var left = new int[] {node.getKey(), node.getValue() - 1};
                    if (left[1] >= 0 && !discovered[left[0]][left[1]]) {
                        discovered[left[0]][left[1]] = true;
                        if (grid[left[0]][left[1]] == '1') {
                            queue.addLast(new Pair(left[0], left[1]));
                        }
                    }
                    var right = new int[] {node.getKey(), node.getValue() + 1};
                    if (right[1] <= w - 1 && !discovered[right[0]][right[1]]) {
                        discovered[right[0]][right[1]] = true;
                        if (grid[right[0]][right[1]] == '1') {
                            queue.addLast(new Pair(right[0], right[1]));
                        }
                    }
                    var up = new int[] {node.getKey() - 1, node.getValue()};
                    if (up[0] >= 0 && !discovered[up[0]][up[1]]) {
                        discovered[up[0]][up[1]] = true;
                        if (grid[up[0]][up[1]] == '1') {
                            queue.addLast(new Pair(up[0], up[1]));
                        }
                    }
                    var down = new int[] {node.getKey() + 1, node.getValue()};
                    if (down[0] <= h - 1 && !discovered[down[0]][down[1]]) {
                        discovered[down[0]][down[1]] = true;
                        if (grid[down[0]][down[1]] == '1') {
                            queue.addLast(new Pair(down[0], down[1]));
                        }
                    }
                }
            }
        }

        return answer;
    }
}
