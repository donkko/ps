package KLIS;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    int[] s;
    int[] cacheLen;
    int[] cacheCnt;

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

    public int count(int start) {
        if(lis(start) == 1) return 1;
        if (cacheCnt[start + 1] != 0) return cacheCnt[start + 1];

        int ret = 0;
        for (int next = start + 1; next < s.length; next++) {
            if ( (start == -1 || s[next] > s[start]) && lis(start) == lis(next) + 1) {
                ret = (int) Math.min(2000000000, (long) ret + (long) count(next));
            }
        }
        cacheCnt[start + 1] = ret;
        return ret;
    }

    public void reconstruct(int start, int skip, List<Integer> answer) {
        if (start != -1) answer.add(s[start]);

        List<Pair> followers = new ArrayList<>();
        for (int next = start + 1; next < s.length; next++) {
            if ((start == -1 || s[next] > s[start]) && lis(start) == lis(next) + 1) {
                followers.add(new Pair(s[next], next));
            }
        }
        followers.sort((a,b) -> a.value - b.value);

        for (int i = 0; i < followers.size(); i++) {
            int idx = followers.get(i).idx;
            int cnt = count(idx);
            if (cnt <= skip) {
                skip -= cnt;
            } else {
                reconstruct(idx, skip, answer);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt(); // 테스트 케이스의 수 (<= 50)
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt(); // 원소의 수 (<= 500)
            int k = scanner.nextInt(); // k번째 있는 LIS를 출력해야 함

            int[] seq = new int[n];
            for (int j = 0; j < n; j++) {
                seq[j] = scanner.nextInt();
            }

            solution.s = seq;
            solution.cacheLen = new int[501];
            solution.cacheCnt = new int[501];

            List<Integer> kthLis = new ArrayList<>();
            solution.reconstruct(-1, k - 1, kthLis);
            System.out.println(kthLis.size());
            System.out.println(kthLis);
        }
    }
}

class Pair {
    int value;
    int idx;

    public Pair(int value, int idx) {
        this.idx = idx;
        this.value = value;
    }
}
