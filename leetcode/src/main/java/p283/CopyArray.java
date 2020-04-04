package p283;

public class CopyArray {
    public void moveZeroes(int[] nums) {
        int[] result = new int[nums.length];
        int zeroCount = 0;
        int resultIdx = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                result[resultIdx] = num;
                resultIdx++;
            }
        }

        for (int i = 0; i < zeroCount; i++) {
            result[resultIdx] = 0;
            resultIdx++;
        }

        System.arraycopy(result, 0, nums, 0, nums.length);
    }
}
