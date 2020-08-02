package C;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    Set<Integer> alreadyNums;
    public int getFirstOccurrence(int k) {
        if (k % 2 == 0) return -1;
        alreadyNums = new HashSet<>();

        int count = 1;
        int dividend = 7;
        while (true) {
            if (dividend % k == 0) return count;
            if (alreadyNums.contains(dividend % k)) return -1;
            alreadyNums.add(dividend % k);
            dividend = (dividend % k) * 10 + 7;
            count++;
        }
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();

        int answer = solution.getFirstOccurrence(k);
        System.out.println(answer);
    }
}

/*
101 -> 4
2 -> -1
999983 -> 999982
 */
