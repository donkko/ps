package C;

import java.util.Scanner;

public class Main {
    public long getDestination(long x, long k, long d) {
        long prevValue = 0;
        long prevPrevValue = 0;
        while (k > 0) {
            if (x == 0) {
                if (k % 2 == 0) {
                    return 0;
                } else {
                    return d;
                }
            } else {
                long jumpK = Math.abs(x) / d;
                jumpK = Math.max(jumpK, 1);
                jumpK = Math.min(jumpK, k);

                k -= jumpK;
                if (x > 0) {
                    x -= jumpK * d;
                } else {
                    x += jumpK * d;
                }

                if (prevPrevValue == x) {
                    if (k % 2 == 0) return Math.abs(x);
                    if (x > 0) return Math.abs(x - d);
                    if (x < 0) return Math.abs(x + d);
                }
                prevPrevValue = prevValue;
                prevValue = x;
            }
        }

        return Math.abs(x);
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long k = scanner.nextLong();
        long d = scanner.nextLong();

        long answer = solution.getDestination(x, k, d);
        System.out.println(answer);
    }
}

/*
6 2 4

2

7 4 3

1

10 1 2

8

1000000000000000 1000000000000000 1000000000000000

1000000000000000

0 100 3

0

20 10000 10

0

20 10001 10

0

21 10001 10

0

19 10000000001 10

0
 */
