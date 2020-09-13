package F;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public int[] reorder(int[] a, int[] b) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        int[] answer = solution.reorder(a, b);
        if (answer == null) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
            System.out.println(answer);
        }
    }
}

/*

 */
