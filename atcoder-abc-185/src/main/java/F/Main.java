package F;

import java.util.*;

public class Main {
    public void solve(int n, int q, int[] a, int[][] queries) {
        for (int[] query : queries) {
            int t = query[0];
            int x = query[1] - 1;
            int y = query[2] - 1;

            if (t == 1) {
                a[x] = a[x]^(y+1);
            }

            if (t == 2) {
                int result = 0;
                for (int i = x; i <= y; i++) {
                    result = result ^ a[i];
                }
                System.out.println(result);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
        }

        solution.solve(n, q, a, queries);
    }
}

/*
3 4
1 2 3
2 1 3
2 2 3
1 2 3
2 2 3

10 10
0 5 3 4 7 0 0 0 1 0
1 10 7
2 8 9
2 3 6
2 1 6
2 1 10
1 9 4
1 6 1
1 6 3
1 1 7
2 3 5

 */
