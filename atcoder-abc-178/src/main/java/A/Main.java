package A;

import java.util.Scanner;

public class Main {
    public int operateNot(int x) {
        if (x == 0) return 1;
        else return 0;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();

        int answer = solution.operateNot(x);
        System.out.println(answer);
    }
}

/*
 */
