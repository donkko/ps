package F;

import java.util.*;
import java.util.function.BiFunction;

public class Main {
    public void solve(int n, int q, int[] a, int[][] queries) {
        SegmentTree segmentTree = new SegmentTree((a1, a2) -> a1 ^ a2, a);

        for (int[] query : queries) {
            int t = query[0];
            int x = query[1] - 1;
            int y = query[2] - 1;

            if (t == 1) {
                segmentTree.update(x, segmentTree.query(x, x) ^ (y+1));
            }

            if (t == 2) {
                System.out.println(segmentTree.query(x, y));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int q = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[][] queries = new int[q][3];
        for (int i = 0; i < q; i++) {
            queries[i][0] = scanner.nextInt();
            queries[i][1] = scanner.nextInt();
            queries[i][2] = scanner.nextInt();
        }

        solution.solve(n, q, a, queries);
    }
}

/*
3 4
1 2 3
2 1 3
2 2 3
1 2 3
2 2 3

10 10
0 5 3 4 7 0 0 0 1 0
1 10 7
2 8 9
2 3 6
2 1 6
2 1 10
1 9 4
1 6 1
1 6 3
1 1 7
2 3 5

 */




class SegmentTree {
    private final BiFunction<Integer, Integer, Integer> operation;
    private final int[] tree;
    private final int n;

    public SegmentTree(BiFunction<Integer, Integer, Integer> operation, int[] arr) {
        this.operation = operation;
        this.n = arr.length;
        this.tree = new int[n * 2];
        buildTree(this.operation, this.tree, arr);
    }

    private void buildTree(BiFunction<Integer, Integer, Integer> operation, int[] tree, int[] inputArr) {
        for (int i = 0; i < n; i++) {
            tree[n + i] = inputArr[i];
        }

        for (int i = n - 1; i > 0; i--) {
            tree[i] = operation.apply(tree[i * 2], tree[i * 2 + 1]);
        }
    }

    /**
     * inclusive [startIdx, endIdx]
     */
    public int query(int startIdx, int endIdx) {
        if (startIdx == endIdx) return tree[n + startIdx];

        int res = 0;
        startIdx = n + startIdx;
        endIdx = n + endIdx;

        while (startIdx < endIdx) {
            if (startIdx % 2 == 1) {
                res = operation.apply(res, tree[startIdx]);
                startIdx++;
            }

            if (endIdx % 2 == 0) {
                res = operation.apply(res, tree[endIdx]);
                endIdx--;
            }

            startIdx = startIdx / 2;
            endIdx = endIdx / 2;
        }
        if (startIdx == endIdx) {
            res = operation.apply(res, tree[startIdx]);
        }

        return res;
    }

    public void update(int idx, int value) {
        tree[n + idx] = value;
        for (int i = n + idx; i > 1; i = i / 2) {
            tree[i / 2] = operation.apply(tree[i], tree[i ^ 1]);
        }
    }
}