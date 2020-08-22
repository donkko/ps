package C;

import java.util.Scanner;

public class Main {
    public long getTotalHeightOfStools(int n, int[] arr) {
        long total = 0;
        int prevHeight = arr[0];
        for (int i = 1; i < n; i++) {
            if (prevHeight > arr[i]) {
                total += prevHeight - arr[i];
                arr[i] = prevHeight;
            }

            prevHeight = arr[i];
        }
        return total;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        long answer = solution.getTotalHeightOfStools(n, arr);
        System.out.println(answer);
    }
}
/*
5
2 1 5 4 3

4

5
3 3 3 3 3

0
 */
