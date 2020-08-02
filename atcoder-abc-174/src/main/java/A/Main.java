package A;

import java.util.Scanner;

public class Main {
    public boolean shouldTurnOn(int temperature) {
        return temperature >= 30;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int temperature = scanner.nextInt();

        boolean shouldTurnOn = solution.shouldTurnOn(temperature);
        if (shouldTurnOn) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

/*
input
25

output
No
 */

/*
input
30

output
Yes
 */
