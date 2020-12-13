package B;

import java.util.*;

public class Main {
    public boolean solve(int n, int m, int t, int[][] cafeFromTo) {
        int currentBattery = n;
        int prevOutTime = 0;

        for (int[] fromTo: cafeFromTo) {
            int from = fromTo[0];
            int to = fromTo[1];

            currentBattery = currentBattery - (from - prevOutTime);
            if (currentBattery <= 0) return false;

            int charged = (to - from);
            currentBattery = Math.min(n, currentBattery + charged);

            prevOutTime = to;
        }
        currentBattery = currentBattery - (t - prevOutTime);
        if (currentBattery <= 0) return false;

        return true;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t = scanner.nextInt();

        int[][] cafeFromTo = new int[m][2];
        for (int i = 0; i < m; i++) {
            cafeFromTo[i][0] = scanner.nextInt();
            cafeFromTo[i][1] = scanner.nextInt();
        }

        boolean answer = solution.solve(n, m, t, cafeFromTo);
        if (answer) System.out.println("Yes");
        else System.out.println("No");
    }
}

/*
10 2 20
9 11
13 17

-> Yes

10 2 20
9 11
13 16

-> No

15 3 30
5 8
15 17
24 27

-> Yes

20 1 30
20 29

-> No

20 1 30
1 10

-> No

 */
