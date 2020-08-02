package B;

import java.util.Scanner;

public class Main {
    Boolean[][] dp = new Boolean[101][101];

    public boolean isCorrect(int animalCount, int legCount) {
        if (dp[animalCount][legCount] != null) {
            return dp[animalCount][legCount];
        }

        // base case
        if (animalCount == 0) {
            dp[animalCount][legCount] = legCount == 0;
            return legCount == 0;
        }

        return isCorrect(animalCount - 1, legCount - 2) || isCorrect(animalCount - 1, legCount - 4);
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        boolean answer = solution.isCorrect(x, y);
        if (answer) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

/*
input
3 8

 */

/*
output
Yes
 */
