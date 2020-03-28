package p994;

import java.util.ArrayList;
import java.util.List;

public class BreadthFirstSearch {
    private int minute = 0;
    private int rowSize;
    private int colSize;

    public int orangesRotting(int[][] grid) {
        rowSize = grid.length;
        colSize = grid[0].length;

        bfs(grid);
        if (isUnrottenOrangeExist(grid)) return -1;
        else return minute;
    }

    private void bfs(int[][] grid) {
        List<List<Integer>> currentRottenOranges = findRottenOranges(grid);
        boolean didRot = false;
        for (List<Integer> rotten : currentRottenOranges) {
            int row = rotten.get(0);
            int col = rotten.get(1);

            if(rot(grid, row, col)) {
                didRot = true;
            }
        }
        if (didRot)  {
            minute++;
            bfs(grid);
        } else {
            return;
        }
    }

    private List<List<Integer>> findRottenOranges(int[][] grid) {
        List<List<Integer>> found = new ArrayList<>();
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 2) {
                    List<Integer> rowCol = new ArrayList<>();
                    rowCol.add(i);
                    rowCol.add(j);
                    found.add(rowCol);
                }
            }
        }
        return found;
    }

    private boolean rot(int[][] grid, int row, int col) {
        boolean didRot = false;
        if (row - 1 >= 0) {
            if (grid[row - 1][col] == 1) {
                grid[row - 1][col] = 2;
                didRot = true;
            }
        }
        if (col - 1 >= 0) {
            if (grid[row][col - 1] == 1) {
                grid[row][col - 1] = 2;
                didRot = true;
            }
        }
        if (row + 1 <= rowSize - 1) {
            if (grid[row + 1][col] == 1) {
                grid[row + 1][col] = 2;
                didRot = true;
            }
        }
        if (col + 1 <= colSize - 1) {
            if (grid[row][col + 1] == 1) {
                grid[row][col + 1] = 2;
                didRot = true;
            }
        }
        return didRot;
    }

    private boolean isUnrottenOrangeExist(int[][] grid) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
