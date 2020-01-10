package MEASURETIME.FenwickTree;

import java.util.Scanner;

public class Main {
    class FenwickTree {
        int[] tree;
        FenwickTree(int n) {
            tree = new int[n + 1];
        }

        int sum(int pos) {
            ++pos;
            int ret = 0;
            while (pos > 0) {
                ret += tree[pos];
                pos = pos & (pos - 1);
            }
            return ret;
        }

        void add(int pos, int val) {
            ++pos;
            while (pos < tree.length) {
                tree[pos] += val;
                pos = pos + (pos & -pos);
            }
        }
    }

    void countMoves(int[] a) {
        FenwickTree ftree = new FenwickTree(1000000);
        long ret = 0;
        for (int i = 0; i < a.length; ++i) {
            ret += ftree.sum(999999) - ftree.sum(a[i]);
            ftree.add(a[i], 1);
        }

        System.out.println(ret);
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
