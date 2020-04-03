package p53;

public class Greedy {
    public int maxSubArray(int[] nums) {
        int maxSumIncludingCurr = nums[0];
        int maxSumEver = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxSumIncludingCurr = Math.max(nums[i], maxSumIncludingCurr + nums[i]);
            maxSumEver = Math.max(maxSumEver, maxSumIncludingCurr);
        }

        return maxSumEver;
    }
}
