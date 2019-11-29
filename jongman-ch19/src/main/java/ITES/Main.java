package ITES;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public int countRanges(int k, int n) {
        RNG rng = new RNG();
        Queue<Integer> range = new LinkedList<>();
        int ret = 0, rangeSum = 0;

        for(int i = 0; i < n; i++) {
            // 구간에 숫자를 추가한다
            int newSignal = rng.next();
            rangeSum += newSignal;
            range.add(newSignal);

            // 구간의 합이 k를 초과하는 동안 구간에서 숫자를 뺀다
            while(rangeSum > k) {
                rangeSum -= range.poll();
            }

            if(rangeSum == k) ret++;
        }

        return ret;
    }

    class RNG {
        long seed;
        RNG() { this.seed = 1983L; }

        int next() {
            long ret = seed;
            seed = ((seed * 214013L) + 2531011L) % (1L << 32);
            return (int) (ret % 10000L + 1L);
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int k = scanner.nextInt();
            int n = scanner.nextInt();
            int result = solution.countRanges(k, n);
            System.out.println(result);
        }
    }
}

/*
input
3
8791 20
5265 5000
3578452 5000000

 */
/*
output
1
4
1049
 */
