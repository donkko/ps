package p5511;

class Solution {
    public int numSpecial(int[][] mat) {
        if (mat == null || mat.length == 0) return 0;

        int n = mat.length;
        int m = mat[0].length;

        int[] rows = new int[n];
        int[] cols = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (rows[i] == 1 && cols[j] == 1 && mat[i][j] == 1) {
                    result++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.numSpecial(new int[][] {{1,0,0},{0,0,1},{1,0,0}});
    }
}
