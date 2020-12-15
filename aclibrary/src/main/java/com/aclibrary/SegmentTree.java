package com.aclibrary;

import java.util.function.BiFunction;

/**
 * https://www.geeksforgeeks.org/segment-tree-efficient-implementation/
 */
public class SegmentTree {
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
