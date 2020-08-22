package E;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public int getMaxTargetsDestroyable(int h, int w, int[][] targets) {
        Map<Integer, Set<Integer>> isTarget = new HashMap<>();
        Map<Integer, Integer> rows = new HashMap<>();
        Map<Integer, Integer> cols = new HashMap<>();

        for (int i = 0; i < targets.length; i++) {
            int targetRow = targets[i][0] - 1;
            int targetCol = targets[i][1] - 1;

            if (!isTarget.containsKey(targetRow)) {
                isTarget.put(targetRow, new HashSet<>());
            }
            isTarget.get(targetRow).add(targetCol);
            rows.put(targetRow, rows.getOrDefault(targetRow, 0) + 1);
            cols.put(targetCol, cols.getOrDefault(targetCol, 0) + 1);
        }

        int max = 0;
        for (int i : rows.keySet()) {
            for (int j : cols.keySet()) {
                int targetsDestroyableRow = rows.getOrDefault(i, 0);
                int targetsDestroyableCol = cols.getOrDefault(j, 0);
                int targetsDestroyable = targetsDestroyableRow + targetsDestroyableCol;
                if (isTarget(isTarget, i, j)) targetsDestroyable--;
                max = Math.max(max, targetsDestroyable);
            }
        }

        return max;
    }
    private boolean isTarget(Map<Integer, Set<Integer>> isTarget, int i, int j) {
        if (!isTarget.containsKey(i)) return false;
        if (!isTarget.get(i).contains(j)) return false;
        return true;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int h = scanner.nextInt();
        int w  = scanner.nextInt();
        int m  = scanner.nextInt();
        int[][] targets = new int[m][2];
        for (int i = 0; i < m; i++) {
            targets[i][0] = scanner.nextInt();
            targets[i][1] = scanner.nextInt();
        }

        int answer = solution.getMaxTargetsDestroyable(h, w, targets);
        System.out.println(answer);
    }
}

/*
2 3 3
2 2
1 1
1 3

3

3 3 4
3 3
3 1
1 1
1 2

3

5 5 10
2 5
4 3
2 3
5 5
2 2
5 4
5 3
5 1
3 5
1 4

6

1 1 1
1 1

1

2 2 4
1 1
1 2
2 1
2 2

3

1 10 10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10

10

300000 300000 1
1 1

1
 */
