package F;

import java.util.Scanner;

public class Main {
    public int getMaximumPoint(int n, int[] cards) {
        int[] count = new int[n + 1];
        for (int card : cards) count[card]++;

        return 0;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[3 * n];
        for (int i = 0; i < a.length; i++) {
            a[i] = scanner.nextInt();
        }

        long answer = solution.getMaximumPoint(n, a);
        System.out.println(answer);
    }
}

/*

 */
