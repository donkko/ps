package p283;

public class TwoPointers2 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int nonZeroIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                if (i == nonZeroIdx) {
                    nonZeroIdx++;
                    continue;
                } else {
                    nums[nonZeroIdx] = nums[i];
                    nums[i] = 0;
                    nonZeroIdx++;
                }
            }
        }
    }
}
