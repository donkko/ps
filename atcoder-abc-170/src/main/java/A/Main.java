package A;

import java.util.Scanner;

public class Main {
    public int getIdx(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        int fourth = scanner.nextInt();
        int fifth = scanner.nextInt();

        int answer = solution.getIdx(new int[] { first, second, third, fourth, fifth });
        System.out.println(answer);
    }
}

/*
input
1 2 0 4 5

 */

/*
output
3
 */
