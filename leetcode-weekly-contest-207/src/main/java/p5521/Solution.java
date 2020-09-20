package p5521;

import java.util.LinkedList;

public class Solution {
    static long MOD = (long) Math.pow(10, 9) + 7L;

    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        long max = Long.MIN_VALUE;
        LinkedList<Elem> q = new LinkedList<>();
        q.addLast(new Elem(0, 0, grid[0][0]));

        while(!q.isEmpty()) {
            Elem elem = q.removeFirst();

            if (elem.row == rows-1 && elem.col == cols-1) {
                max = Math.max(max, elem.product);
            }

            if (elem.product == 0) {
                max = Math.max(max, 0);
                continue;
            }

            // right
            if (elem.col + 1 < grid[0].length) {
                q.addLast(new Elem(elem.row, elem.col + 1, elem.product * grid[elem.row][elem.col + 1]));
            }

            // down
            if (elem.row + 1 < grid.length) {
                q.addLast(new Elem(elem.row + 1, elem.col, elem.product * grid[elem.row + 1][elem.col]));
            }
        }

        if (max < 0) {
            return -1;
        } else {
            return (int) (max % MOD);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.maxProductPath(new int[][]{
                {2, 1, 3, 0, -3, 3, -4, 4, 0, -4},
                {-4, -3, 2, 2, 3, -3, 1, -1, 1, -2},
                {-2, 0, -4, 2, 4, -3, -4, -1, 3, 4},
                {-1, 0, 1, 0, -3, 3, -2, -3, 1, 0},
                {0, -1, -2, 0, -3, -4, 0, 3, -2, -2},
                {-4, -2, 0, -1, 0, -3, 0, 4, 0, -3},
                {-3, -4, 2, 1, 0, -4, 2, -4, -1, -3},
                {3, -2, 0, -4, 1, 0, 1, -3, -1, -1},
                {3, -4, 0, 2, 0, -2, 2, -4, -2, 4},
                {0, 4, 0, -3, -4, 3, 3, -1, -2, -2}
        });
    }
}

class Elem {
    int row;
    int col;
    long product;
    Elem(int row, int col, long product) {
        this.row = row;
        this.col = col;
        this.product = product;
    }
}