package A;

import java.util.*;

public class Main {
    public int solve(int a1, int a2, int a3, int a4) {
        return Math.min(Math.min(a1, a2), Math.min(a3, a4));
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int a2 = scanner.nextInt();
        int a3 = scanner.nextInt();
        int a4 = scanner.nextInt();

        int answer = solution.solve(a1, a2, a3, a4);
        System.out.println(answer);
    }
}

/*
5 3 7 11

100 100 1 100

 */
