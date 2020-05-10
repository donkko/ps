package p367;

// Result: TLE
public class BruteForce {
    public boolean isPerfectSquare(int num) {
        int i = 1;
        int iSquare = 1;
        while (iSquare <= num) {
            iSquare = i * i;
            if (iSquare == num) {
                return true;
            }

            i++;
        }
        return false;
    }

    public static void main(String[] args) {
        var solution = new BruteForce();
        System.out.println(solution.isPerfectSquare(1));
        System.out.println(solution.isPerfectSquare(2));
        System.out.println(solution.isPerfectSquare(3));
        System.out.println(solution.isPerfectSquare(4));
        System.out.println(solution.isPerfectSquare(5));
    }
}
