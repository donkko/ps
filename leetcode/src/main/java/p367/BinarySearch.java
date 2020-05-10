package p367;

public class BinarySearch {
    public boolean isPerfectSquare(int num) {
        if (num < 0) return true;
        if (num == 0) return true;
        if (num == 1) return true;

        int left = 1;
        int right = num / 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long midSquare = (long) mid * (long) mid;
            if (midSquare == num) {
                return true;
            } else if (midSquare < num) {
                left = mid + 1;
            } else if (midSquare > num) {
                right = mid - 1;
            }
        }
        return false;
    }
}
