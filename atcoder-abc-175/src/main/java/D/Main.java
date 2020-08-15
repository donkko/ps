package D;

import java.util.Scanner;

public class Main {
    public long getHighestScore(int n, int k, int[] p, int[] c) {





        return 0;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k  = scanner.nextInt();
        int[] p = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            c[i] = scanner.nextInt();
        }

        long answer = solution.getHighestScore(n, k, p, c);
        System.out.println(answer);
    }
}

/*
5 2
2 4 5 1 3
3 4 -10 -8 8

8
 */
