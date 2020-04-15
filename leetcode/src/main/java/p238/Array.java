package p238;

public class Array {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int productOfLeft = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                answer[i] = 1;
                continue;
            }
            productOfLeft *= nums[i - 1];
            answer[i] = productOfLeft;
        }

        int productOfRight = 1;
        for (int j = n - 1; j >= 0; j--) {
            if (j == n - 1) {
                continue;
            }
            productOfRight *= nums[j + 1];
            answer[j] *= productOfRight;
        }

        return answer;
    }
}
