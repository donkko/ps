package p476;

public class BitManipulation {
    public int findComplement(int num) {
        int tempNum = num;
        int digit = 0;
        while(tempNum != 0) {
            digit++;
            tempNum = tempNum >> 1;
        }
        int bitMask = (1 << digit) - 1;
        return num ^ bitMask;
    }

    public static void main(String[] args) {
        var solution = new BitManipulation();
        System.out.println(solution.findComplement(5));
        System.out.println(solution.findComplement(1));
        System.out.println(solution.findComplement(0));
    }
}
