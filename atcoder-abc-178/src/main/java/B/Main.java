package B;

import java.util.Scanner;

public class Main {
    public long getMaxProduct(int a, int b, int c, int d) {
        long cand1 = (long) a * (long) c;
        long cand2 = (long) a * (long) d;
        long cand3 = (long) b * (long) c;
        long cand4 = (long) b * (long) d;
        return Math.max(Math.max(cand1, cand2), Math.max(cand3, cand4));
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();

        long answer = solution.getMaxProduct(a, b, c, d);
        System.out.println(answer);
    }
}

/*
1 2 1 1

2

3 5 -4 -2

-6

-1000000000 0 -1000000000 0

1000000000000000000
 */
