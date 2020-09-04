package LIS;

import java.util.Scanner;

public class Main {

    int[] s;
    int[] cacheLen;

    public int getLengthOfLis(int[] s) {
        cacheLen = new int[501];

        int maxLength = 0;
        for (int i = 0; i < s.length; i++) {
            maxLength = Math.max(maxLength, lis(i));
        }
        return maxLength;
    }

    public int lis(int start) {
        if (cacheLen[start + 1] != 0) return cacheLen[start + 1];

        int ret = 1;
        for (int next = start + 1; next < s.length; next++) {
            if (start == -1 || s[next] > s[start]) {
                ret = Math.max(ret, 1 + lis(next));
            }
        }
        cacheLen[start + 1] = ret;
        return ret;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt(); // 테스트 케이스의 개수
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt(); // 원소의 개수

            int[] seq = new int[n];
            for (int j = 0; j < n; j++) {
                seq[j] = scanner.nextInt();
            }

            solution.s = seq;
            solution.cacheLen = new int[501];
            int result = solution.lis(-1);
            System.out.println(result - 1);
        }
    }
}
