package p201;

public class BitManipulation {
    public int rangeBitwiseAnd(int m, int n) {
        int digit = 0;
        while (m != n) {
            digit++;
            m = (m >> 1);
            n = (n >> 1);
        }
        return m << digit;
    }
}
