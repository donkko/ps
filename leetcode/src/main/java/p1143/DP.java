package p1143;

import java.util.Arrays;

// Solution 다시 한번 정독하기!

public class DP {
    String text1;
    String text2;
    int[][] cache;
    public int longestCommonSubsequence(String text1, String text2) {
        cache = new int[text1.length()][text2.length()];
        for (int[] vals : cache) {
            Arrays.fill(vals, -1);
        }
        this.text1 = text1;
        this.text2 = text2;

        return getCommonSubsequence(text1.length() - 1, text2.length() - 1);
    }

    private int getCommonSubsequence(int idx1, int idx2) {
        if (idx1 < 0 || idx2 < 0) return 0;

        int cached = cache[idx1][idx2];
        if (cached != -1) {
            return cached;
        }

        int result;
        if (idx1 == 0) {
            int idx = text2.indexOf(text1.charAt(0));
            result = (idx >= 0 && idx <= idx2)? 1 : 0;
        } else if (idx2 == 0) {
            int idx = text1.indexOf(text2.charAt(0));
            result = (idx >= 0 && idx <= idx1)? 1 : 0;
        } else {
            if (text1.charAt(idx1) == text2.charAt(idx2)) {
                result = getCommonSubsequence(idx1 - 1, idx2 - 1) + 1;
            } else {
                result = Math.max(getCommonSubsequence(idx1 - 1, idx2), getCommonSubsequence(idx1, idx2 - 1));
            }
        }

        cache[idx1][idx2] = result;
        return result;
    }

    public static void main(String[] args) {
        var solution = new DP();
        //"abc"
        //"def"
        System.out.println(solution.longestCommonSubsequence("abc", "def"));
    }
}
