package A;

import java.util.Scanner;

public class Main {
    public int getMaximumNumberOfConsecutiveRainyDays(String s) {
        int maxStreak = 0;
        int streak = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'R') {
                streak++;
            } else {
                maxStreak = Math.max(maxStreak, streak);
                streak = 0;
            }
        }
        maxStreak = Math.max(maxStreak, streak);

        return maxStreak;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        int answer = solution.getMaximumNumberOfConsecutiveRainyDays(s);
        System.out.println(answer);
    }
}

/*
RRS

2

SSS

0

RSR

1

 */
