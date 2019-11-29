package JOSEPHUS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    void josephus(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        // 큐에 병사 넣기
        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        // 1번 병사 죽이기
        queue.poll();

        while(queue.size() > 2) {
            for (int i = 1; i <= k; i++) {
                if (i == k) {
                    // k번째 병사이면 죽인다
                    queue.poll();
                } else {
                    // 그 외의 경우 큐의 맨 뒤로 보낸다
                    queue.add(queue.poll());
                }
            }
        }

        int survivor1 = queue.poll();
        int survivor2 = queue.poll();
        if (survivor1 < survivor2) System.out.println(survivor1 + " " + survivor2);
        else System.out.println(survivor2 + " " + survivor1);
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for(int i = 0; i < numberOfTests; i++) {
            int n = scanner.nextInt(); // number of soldiers
            int k = scanner.nextInt(); // k th
            solution.josephus(n, k);
        }
    }
}

/*
input
2
6 3
40 3

 */
/*
output
3 5
11 26
 */
