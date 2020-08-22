package A;

import java.util.Scanner;

public class Main {
    public int getTime(int n, int x, int t) {
        if (n % x == 0) return (n / x) * t;
        else return (n / x + 1) * t;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int t = scanner.nextInt();

        int answer = solution.getTime(n, x, t);
        System.out.println(answer);
    }
}

/*
20 12 6

12

1000 1 1000

1000000
 */
