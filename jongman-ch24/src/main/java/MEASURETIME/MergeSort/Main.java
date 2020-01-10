package MEASURETIME.MergeSort;

import java.util.Scanner;

public class Main {
    void countMoves(int[] a) {
        System.out.println(countMoves(a, 0, a.length - 1));
    }

    long countMoves(int[] a, int left, int right) {
        if (left == right) return 0; // 기저사례: 구간의 길이라 1이라면 이미 정렬되었고, inversion도 없다

        // 반으로 나눠서 부분 정복
        int mid = (left + right) / 2;
        long ret = countMoves(a, left, mid) + countMoves(a, mid + 1, right);

        // 임시 배열에 정렬된 두 부분 배열을 합친다.
        int tmp[] = new int[right - left + 1];
        int tmpIndex = 0;
        int leftIndex = left;
        int rightIndex = mid + 1;
        while (leftIndex <= mid || rightIndex <= right) {
            if (leftIndex <= mid && (rightIndex > right || a[leftIndex] <= a[rightIndex])) {
                tmp[tmpIndex++] = a[leftIndex++];
            } else {
                // a[rightIndex] 는 왼쪽 부분 배열에 남아 있는 모든 수보다 작다.
                // 이 수들만큼 inversion 을 더해준다.
                ret += mid - leftIndex + 1;
                tmp[tmpIndex++] = a[rightIndex++];
            }
        }

        // tmp 에 합친 결과를 A로 다시 복사한다.
        for (int i = 0; i < tmp.length; ++i) {
            a[left + i] = tmp[i];
        }

        return ret;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int n = scanner.nextInt(); // size of array
            int[] a = new int[n];
            for (int j = 0; j < n; j++) {
                a[j] = scanner.nextInt(); // array elements
            }
            solution.countMoves(a);
        }
    }
}

/*
input
2
5
5 1 4 3 2
10
7 8 6 6 1 9 4 4 3 10

 */
/*
output
7
25
 */
