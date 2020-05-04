package p1009;

public class BitManipulation {
    public int bitwiseComplement(int N) {
        if (N == 0) return 1;

        int tempNum = N;
        int digit = 0;
        while(tempNum != 0) {
            digit++;
            tempNum = tempNum >> 1;
        }
        int bitMask = (1 << digit) - 1;
        return N ^ bitMask;
    }

    public static void main(String[] args) {
        var solution = new BitManipulation();
        System.out.println(solution.bitwiseComplement(5));
        System.out.println(solution.bitwiseComplement(7));
        System.out.println(solution.bitwiseComplement(10));
    }
}
