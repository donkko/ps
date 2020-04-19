package p33;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return nums[0] == target? 0 : -1;

        int smallestIdx = findDescendingIdx(nums);
        if (smallestIdx == -1) {
            return findTarget(nums, 0, n - 1, target);
        } else {
            if (nums[n - 1] < target) {
                return findTarget(nums, 0, smallestIdx - 1, target);
            } else {
                return findTarget(nums, smallestIdx, n - 1, target);
            }
        }
    }

    private static int findDescendingIdx(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) return -1;

        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid == n - 1) return -1;
            if (nums[mid] > nums[mid + 1]) return mid + 1;

            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    private static int findTarget(int[] nums, int fromIdx, int toIdx, int target) {
        int left = fromIdx;
        int right = toIdx;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;

            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(BinarySearch.findDescendingIdx(new int[]{8,9,2,3,4}));
    }
}
