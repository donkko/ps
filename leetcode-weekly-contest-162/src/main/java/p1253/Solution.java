package p1253;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int numOfColumns = colsum.length;
        List<Integer> upperRow = new ArrayList<>(numOfColumns);
        List<Integer> lowerRow = new ArrayList<>(numOfColumns);

        for (int sum : colsum) {
            switch (sum) {
                case 2:
                    if (upper == 0 || lower == 0) return Collections.emptyList();
                    upper -= 1;
                    lower -= 1;
                    upperRow.add(1);
                    lowerRow.add(1);
                    break;

                case 1:
                    if (upper == 0 && lower == 0) return Collections.emptyList();

                    if (upper >= lower) {
                        upper -= 1;
                        upperRow.add(1);
                        lowerRow.add(0);
                    } else {
                        lower -= 1;
                        upperRow.add(0);
                        lowerRow.add(1);
                    }
                    break;

                case 0:
                    upperRow.add(0);
                    lowerRow.add(0);
                    break;
            }
        }

        if (upper != 0 || lower != 0) return Collections.emptyList();

        return Arrays.asList(upperRow, lowerRow);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int upper = 4;
        int lower = 7;
        int[] colsum = new int[] {2,1,2,2,1,1,1};
        solution.reconstructMatrix(upper, lower, colsum);
    }
}
