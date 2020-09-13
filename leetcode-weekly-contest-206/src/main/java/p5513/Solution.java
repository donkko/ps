package p5513;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int[] ds;
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;

        int n = points.length;
        ds = new int[n];
        for (int i = 0; i < n; i++) ds[i] = i;
        List<Dist> dists = new ArrayList<Dist>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dists.add(new Dist(getDist(points[i], points[j]), i, j));
            }
        }

        dists.sort((a,b) -> a.distance - b.distance);
        int answer = 0;
        for (Dist d : dists) {
            if (find(d.p1) != find(d.p2)) {
                union(d.p1, d.p2);
                answer += d.distance;
            }
        }
        return answer;
    }
    private int find(int pointIdx) {
        if (pointIdx == ds[pointIdx]) {
            return pointIdx;
        }
        int leader = find(ds[pointIdx]);
        ds[pointIdx] = leader;
        return leader;
    }
    private void union(int i1, int i2) {
        ds[find(i2)] = find(i1);
    }
    private int getDist(int[] point1, int[] point2) {
        int x1 = point1[0];
        int x2 = point2[0];
        int y1 = point1[1];
        int y2 = point2[1];
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minCostConnectPoints(new int[][] {{0,0},{1,1},{1,0},{-1,1}});
    }
}

class Dist {
    int distance;
    int p1;
    int p2;
    Dist(int distance, int p1, int p2) {
        this.distance = distance;
        this.p1 = p1;
        this.p2 = p2;
    }
}
