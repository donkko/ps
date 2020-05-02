package p278;

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}

public class BinarySearch extends VersionControl {
    public int firstBadVersion(int n) {
        if (this.isBadVersion(0)) return 0;
        if (this.isFirstBadVersion(n)) return n;
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (this.isFirstBadVersion(mid)) return mid;

            if (this.isBadVersion(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    private boolean isFirstBadVersion(int version) {
        if (this.isBadVersion(version)) {
            return version == 0 || !this.isBadVersion(version - 1);
        } else {
            return false;
        }
    }
}
