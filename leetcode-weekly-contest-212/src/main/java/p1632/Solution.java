package p1632;

import java.util.*;

// 이 코드는 답이 아님. 특정 tc에서 Wrong Answer 나오는데 시간이 없어서 포기.
public class Solution {
    public int[][] matrixRankTransform(int[][] matrix) {
        int nRows = matrix.length;
        int nCols = matrix[0].length;
        int n = nRows * nCols;

        List<int[]> elems = new ArrayList<>(n);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                int num = matrix[i][j];
                elems.add(new int[] {i, j, num});
            }
        }
        elems.sort((a, b) -> a[2] - b[2]);

        Map<Integer, int[]> maxValueAndRankOfRowMap = new HashMap<>();
        Map<Integer, int[]> maxValueAndRankOfColMap = new HashMap<>();
        int[][] answer = new int[nRows][nCols];
        for (int[] elem : elems) {
            int row = elem[0];
            int col = elem[1];
            int value = elem[2];

            int[] maxValueAndRankOfRow = maxValueAndRankOfRowMap.get(row);
            int[] maxValueAndRankOfCol = maxValueAndRankOfColMap.get(col);
            if (maxValueAndRankOfRow == null && maxValueAndRankOfCol == null) {
                answer[row][col] = 1;
                maxValueAndRankOfRowMap.put(row, new int[] {value, 1});
                maxValueAndRankOfColMap.put(col, new int[] {value, 1});
            } else if (maxValueAndRankOfRow != null && maxValueAndRankOfCol == null) {
                int maxValue = maxValueAndRankOfRow[0];
                int maxRank = maxValueAndRankOfRow[1];
                if (maxValue == value) {
                    answer[row][col] = maxRank;
                } else if (maxValue < value) {
                    answer[row][col] = maxRank + 1;
                }
                maxValueAndRankOfRowMap.put(row, new int[] {value, answer[row][col]});
                maxValueAndRankOfColMap.put(col, new int[] {value, answer[row][col]});
            } else if (maxValueAndRankOfRow == null && maxValueAndRankOfCol != null) {
                int maxValue = maxValueAndRankOfCol[0];
                int maxRank = maxValueAndRankOfCol[1];
                if (maxValue == value) {
                    answer[row][col] = maxRank;
                } else if (maxValue < value) {
                    answer[row][col] = maxRank + 1;
                }
                maxValueAndRankOfRowMap.put(row, new int[] {value, answer[row][col]});
                maxValueAndRankOfColMap.put(col, new int[] {value, answer[row][col]});
            } else {
                int maxValueOfRow = maxValueAndRankOfRow[0];
                int maxRankOfRow = maxValueAndRankOfRow[1];
                int maxValueOfCol = maxValueAndRankOfCol[0];
                int maxRankOfCol = maxValueAndRankOfCol[1];

                if (maxValueOfRow == value && maxValueOfCol == value) {
                    answer[row][col] = maxRankOfRow;
                } else if (maxValueOfRow < value && maxValueOfCol == value) {
                    answer[row][col] = maxRankOfCol;
                } else if (maxValueOfRow == value && maxValueOfCol < value) {
                    answer[row][col] = maxRankOfRow;
                } else if (maxValueOfRow < value && maxValueOfCol < value) {
                    answer[row][col] = Math.max(maxRankOfCol, maxRankOfRow) + 1;
                }
                maxValueAndRankOfRowMap.put(row, new int[] {value, answer[row][col]});
                maxValueAndRankOfColMap.put(col, new int[] {value, answer[row][col]});
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {-37, -50,  -3,  44},
                {-37,  46,  13, -32},
                {47,  -42,  -3, -40},
                {-17, -22,  -39, 24}
        };
        Solution solution = new Solution();
        solution.matrixRankTransform(input);
    }
}
