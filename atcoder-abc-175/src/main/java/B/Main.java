package B;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public int countTriangles(int[] lengths) {
        if (lengths.length < 3) return 0;

        Map<Integer, Integer> uniqueMap = new HashMap<>();
        for (int length : lengths) {
            uniqueMap.put(length, uniqueMap.getOrDefault(length, 0) + 1);
        }

        int count = 0;
        Integer[] uniqueLengths = uniqueMap.keySet().toArray(new Integer[0]);
        for (int i = 0; i < uniqueLengths.length; i++) {
            for (int j = i + 1; j < uniqueLengths.length; j++) {
                for (int k = j + 1; k < uniqueLengths.length; k++) {
                    if (!canFormTriangle(uniqueLengths[i], uniqueLengths[j], uniqueLengths[k])) {
                        continue;
                    }
                    count += uniqueMap.get(uniqueLengths[i]) * uniqueMap.get(uniqueLengths[j]) * uniqueMap.get(uniqueLengths[k]);
                }
            }
        }

        return count;
    }
    private boolean canFormTriangle(int a, int b, int c) {
        return a < b + c && b < a + c && c < a + b;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] lengths = new int[n];

        for (int i = 0; i < n; i++) {
            lengths[i] = scanner.nextInt();
        }

        int answer = solution.countTriangles(lengths);
        System.out.println(answer);
    }
}

/*
5
4 4 9 7 5

5

6
4 5 4 3 3 5

8

10
9 4 6 1 9 6 10 6 6 8

39

2
1 1

0
 */
