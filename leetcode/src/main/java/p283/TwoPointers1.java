package p283;

public class TwoPointers1 {
    public void moveZeroes(int[] nums) {
        int nonZeroIdx = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[nonZeroIdx] = nums[i];
                nonZeroIdx++;
            }
        }

        for (int j = nonZeroIdx; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}
