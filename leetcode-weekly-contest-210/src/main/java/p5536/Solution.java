package p5536;

public class Solution {

    public int maximalNetworkRank(int n, int[][] roads) {
        boolean[][] cities = new boolean[n][n];
        for (int[] road : roads) {
            cities[road[0]][road[1]] = true;
            cities[road[1]][road[0]] = true;
        }

        int[] nRoadsFrom = new int[n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (cities[i][j]) count++;
            }
            nRoadsFrom[i] = count;
        }

        int maxNetworkRank = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = nRoadsFrom[i] + nRoadsFrom[j];
                if (cities[i][j]) {
                    sum--;
                }
                maxNetworkRank = Math.max(maxNetworkRank, sum);
            }
        }
        return maxNetworkRank;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
