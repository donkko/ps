package E;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            arr[i][0] = x;
            arr[i][1] = y;
        }
    }
}

/*

 */
