package B;

import java.util.Scanner;

public class Main {
    public boolean isMultipleOfNine(String num) {
        int sum = 0;
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            sum += digit;
        }

        if (num.length() < 10) {
            return sum % 9 == 0;
        } else {
            return isMultipleOfNine(String.valueOf(sum));
        }
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();

        boolean answer = solution.isMultipleOfNine(n);
        if (answer) System.out.println("Yes");
        else System.out.println("No");
    }
}

/*
123456789 -> Yes
0 -> Yes
31415926535897932384626433832795028841971693993751058209749445923078164062862089986280 -> No
 */
