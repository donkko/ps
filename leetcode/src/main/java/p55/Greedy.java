package p55;

// DP로도 풀어보자!

public class Greedy {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) return false;
        if (n == 1) return true;

        int minCountToJump;
        int minPositionToJump = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            minCountToJump = minPositionToJump - i;
            if (nums[i] >= minCountToJump) {
                minPositionToJump = i;
            }
        }
        return minPositionToJump == 0;
    }
}
