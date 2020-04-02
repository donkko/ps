package p202;

import java.util.HashSet;

public class Recursion {
    HashSet<Integer> cached = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 1) {
            return true;
        } else if (cached.contains(n)) {
            return false;
        }

        cached.add(n);
        int sumOfSquaresOfDigit = getSumOfSquaresOfDigit(n);
        return isHappy(sumOfSquaresOfDigit);
    }

    private int getSumOfSquaresOfDigit(int n) {
        if (n / 10 == 0) return (n % 10) * (n % 10);
        return (n % 10) * (n % 10) + getSumOfSquaresOfDigit(n / 10);
    }
}
