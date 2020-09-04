package MORSE;

import java.util.Scanner;

public class Main {
    int[][] combination;

    public void printKthMorseCode(int n, int m, int k) {
        combination = new int[201][201];
        calcCombination();
        System.out.println(generate(n, m, k - 1));
    }

    private void calcCombination() {
        for (int i = 0; i <= 200; i++) {
            combination[i][0] = 1; // C(n, 0) == 1
            combination[i][i] = 1; // C(n, n) == 1
            for (int j = 1; j <= i; j++) {
                // C(n, k) == C(n-1, k-1) + C(n-1, k)
                if (combination[i - 1][j - 1] + combination[i - 1][j] > 1000000000) {
                    combination[i][j] = 1000000000;
                } else {
                    combination[i][j] = combination[i - 1][j - 1] + combination[i - 1][j];
                }
            }
        }
    }

    private String generate(int n, int m, int skip) {
        if (n == 0) {
            String s = "";
            for (int i = 0; i < m; i++) s += "o";
            return s;
        }

        if (skip < combination[n - 1 + m][n - 1]) {
            return "-" + generate(n - 1, m, skip);
        } else {
            return "o" + generate(n, m - 1, skip - combination[n - 1 + m][n - 1]);
        }
    }


    public static void main(String[] args) {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt(); // 테스트 케이스의 개수
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt(); // 장점(-)의 개수
            int m = scanner.nextInt(); // 단점(o)의 개수
            int k = scanner.nextInt(); // k번째 신호를 출력해야 한다

            solution.printKthMorseCode(n, m, k);
        }
    }
}
