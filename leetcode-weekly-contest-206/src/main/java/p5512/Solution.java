package p5512;

class Solution {
    int[][] preferences;
    int[][] prefRank;
    int[] pairMap;

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;

        this.preferences = preferences;
        this.prefRank = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n-1; j++) {
                int friend = preferences[i][j];
                prefRank[i][friend] = j;
            }
        }
        this.pairMap = new int[n];
        for (int[] pair : pairs) {
            pairMap[pair[0]] = pair[1];
            pairMap[pair[1]] = pair[0];
        }

        int result = 0;
        for (int[] pair : pairs) {
            int left = pair[0];
            int right = pair[1];

            boolean leftIsUnhappy = false;
            for (int i = 0; i < getPrefRank(left, right); i++) {
                int morePreferFriend = preferences[left][i];
                if (getPrefRank(morePreferFriend, getPairOf(morePreferFriend)) > getPrefRank(morePreferFriend, left))
                    leftIsUnhappy = true;
            }

            boolean rightIsUnhappy = false;
            for (int i = 0; i < getPrefRank(right, left); i++) {
                int morePreferFriend = preferences[right][i];
                if (getPrefRank(morePreferFriend, getPairOf(morePreferFriend)) > getPrefRank(morePreferFriend, right))
                    rightIsUnhappy = true;
            }

            if (leftIsUnhappy) result++;
            if (rightIsUnhappy) result++;
        }
        return result;
    }

    private int getPrefRank(int who, int friend) {
        return prefRank[who][friend];
    }
    private int getPairOf(int who) {
        return pairMap[who];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.unhappyFriends(4,
                new int[][] {{1, 2, 3}, {3, 2, 0}, {3, 1, 0}, {1, 2, 0}},
                new int[][]{{0, 1}, {2, 3}});
    }
}
