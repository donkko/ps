package B;

import java.util.Scanner;

public class Main {
    public int count(int n, double d, int[][] coords) {
        int count = 0;
        for (int[] coord : coords) {
            double x = coord[0];
            double y = coord[1];

            if (Math.abs(x) > d || Math.abs(y) > d) {
                continue;
            } else {
                double dist = Math.sqrt(x * x + y * y);
                if (dist <= d) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();

        int[][] coords = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            coords[i][0] = x;
            coords[i][1] = y;
        }

        int answer = solution.count(n, d, coords);
        System.out.println(answer);
    }
}

/*
input
20 100000
14309 -32939
-56855 100340
151364 25430
103789 -113141
147404 -136977
-37006 -30929
188810 -49557
13419 70401
-88280 165170
-196399 137941
-176527 -61904
46659 115261
-153551 114185
98784 -6820
94111 -86268
-30401 61477
-55056 7872
5901 -163796
138819 -185986
-69848 -96669
 */

/*
output
6
 */
