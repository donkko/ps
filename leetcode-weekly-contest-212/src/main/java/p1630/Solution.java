package p1630;

import java.util.*;

public class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        int[][] ranges = new int[m][2];
        for (int i = 0; i < m; i++) {
            ranges[i][0] = l[i];
            ranges[i][1] = r[i];
        }

        List<Boolean> answer = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            int fromIdx = l[i];
            int toIdx = r[i];
            answer.add(isArithmetic(nums, fromIdx, toIdx));
        }
        return answer;
    }

    private boolean isArithmetic(int[] nums, int fromIdx, int toIdx) {
        int length = toIdx - fromIdx + 1;
        if (length <= 2) return true;

        int[] newArr = new int[length];
        for (int i = fromIdx; i <= toIdx; i++) {
            newArr[i - fromIdx] = nums[i];
        }
        Arrays.sort(newArr);
        int diff = newArr[1] - newArr[0];
        for (int i = 2; i < newArr.length; i++) {
            if (newArr[i] - newArr[i - 1] != diff) return false;
        }
        return true;
    }
}
