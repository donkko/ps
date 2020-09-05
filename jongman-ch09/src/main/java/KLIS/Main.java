package KLIS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    int skip;
    int[] s;
    int[] cacheLen;
    int[] cacheCnt;

    int lis(int start) {
        if (cacheLen[start + 1] != 0) return cacheLen[start + 1];

        int maxLength = 1;
        for (int i = start + 1; i < s.length; i++) {
            if (start == -1 || s[start] < s[i]) {
                maxLength = Math.max(maxLength, 1 + lis(i));
            }
        }

        cacheLen[start + 1] = maxLength;
        return maxLength;
    }

    int count(int start) {
        if (lis(start) == 1) return 1;
        if (cacheCnt[start + 1] != 0) return cacheCnt[start + 1];

        int count = 0;
        for (int i = start + 1; i < s.length; i++) {
            if ( (start == -1 || s[start] < s[i]) && lis(start) == lis(i) + 1 ) {
                count = (int) Math.min((long) count + (long) count(i), 2000000000L);
            }
        }

        cacheCnt[start + 1] = count;
        return count;
    }

    void reconstruct(int start, List<Integer> lis) {
        if (start != -1) lis.add(s[start]);

        List<Integer> followers = new ArrayList<>();
        for (int i = start + 1; i < s.length; i++) {
            if ( (start == -1 || s[start] < s[i]) && lis(start) == lis(i) + 1 ) {
                followers.add(i);
            }
        }
        followers.sort((a,b) -> s[a] - s[b]);

        for (int i = 0; i < followers.size(); i++) {
            int idx = followers.get(i);
            int cnt = count(idx);
            if (cnt <= skip) {
                skip -= cnt;
            } else {
                reconstruct(idx, lis);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt(); // 테스트 케이스의 수
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt(); // 원소의 수
            int k = scanner.nextInt(); // k번째 LIS를 출력해야 한다

            int[] seq = new int[n];
            for (int j = 0; j < n; j++) {
                seq[j] = scanner.nextInt();
            }

            Main solution = new Main();
            solution.skip = k - 1;
            solution.s = seq;
            solution.cacheLen = new int[501];
            solution.cacheCnt = new int[501];
            List<Integer> answer = new ArrayList<>();
            solution.reconstruct(-1, answer);
            System.out.println(answer.size());
            for (int elem : answer) System.out.print(elem + " ");
            System.out.println();
        }
    }
}


/*
-1     0  1  2  3  4  5
-INF   9, 1, 4, 3, 2, 8

9로 시작하는 LIS의 개수 = 1
1로 시작하는 LIS의 개수 = 3
4로 시작하는 LIS의 개수 = 1
3로 시작하는 LIS의 개수 = 1
2로 시작하는 LIS의 개수 = 1
8로 시작하는 LIS의 개수 = 1

 */