package p1428;

import java.util.List;

interface BinaryMatrix {
    int get(int x, int y);
    List<Integer> dimensions();
 };

public class BinarySearch {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int n = binaryMatrix.dimensions().get(0);
        int m = binaryMatrix.dimensions().get(1);

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = m - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int midValue = binaryMatrix.get(i, mid);
                if (midValue == 0) {
                    left = mid + 1;
                } else if (midValue == 1) {
                    if (mid == 0 || binaryMatrix.get(i, mid - 1) == 0) {
                        answer = Math.min(answer, mid);
                        if (answer == 0) return answer;
                        break;
                    }
                    right = mid - 1;
                } else {
                    return -1;
                }
            }
        }

        if (answer == Integer.MAX_VALUE) return -1;
        else return answer;
    }
}
