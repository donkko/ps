package D;

import java.util.*;

public class Main {
    public int solve(int n, int m, int[] blueSquares) {
        if (m == 0) return 1;

        Arrays.sort(blueSquares);
        int stampSize = getBiggestStampSize(n, m, blueSquares);
        if (stampSize == 0) return 0;

        int answer = 0;

        int interval = 0;
        if (blueSquares[0] != 1) {
            interval = blueSquares[0] - 1;
            if (interval % stampSize == 0) {
                answer += (interval / stampSize);
            } else {
                answer += (interval / stampSize) + 1;
            }
        }
        for (int i = 1; i < m; i++) {
            interval = blueSquares[i] - blueSquares[i - 1] - 1;

            if (interval % stampSize == 0) {
                answer += (interval / stampSize);
            } else {
                answer += (interval / stampSize) + 1;
            }
        }
        if (blueSquares[m - 1] != n) {
            interval = n - blueSquares[m - 1];
            if (interval % stampSize == 0) {
                answer += (interval / stampSize);
            } else {
                answer += (interval / stampSize) + 1;
            }
        }

        return answer;
    }
    private int getBiggestStampSize(int n, int m, int[] blueSquares) {
        int result = n;
        if (blueSquares[0] != 1) result = Math.min(result, blueSquares[0] - 1);
        for (int i = 1; i < m; i++) {
            int interval = blueSquares[i] - blueSquares[i - 1] - 1;
            if (interval == 0) continue;
            result = Math.min(result, interval);
        }
        if (blueSquares[m - 1] != n) result = Math.min(result, n - blueSquares[m - 1]);

        return result;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] blueSquares = new int[m];
        for (int i = 0; i < m; i++) {
            blueSquares[i] = scanner.nextInt();
        }

        int answer = solution.solve(n, m, blueSquares);
        System.out.println(answer);
    }
}

/*
5 2
1 3

-> 3

13 3
13 3 9

-> 6

5 5
5 2 1 4 3

-> 0

1 0

-> 1

1 1
1

-> 0

12 1
12

-> 1

12 1
1

-> 1

12 1
2

-> 11

5 2
3 4

->
 */
