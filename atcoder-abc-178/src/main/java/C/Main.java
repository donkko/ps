package C;

import java.util.Scanner;

public class Main {
    long MOD = (long) Math.pow(10, 9) + 7L;

    public int countSequences(int n) {
        if (n < 2) return 0;

        // 10 ^ (n-2) * C(n,2)
        // C(n,2) = n*(n-1)/2
        long a = getMod(n - 2);
        long b = ((long) n * (long) (n - 1)) % MOD;
        long res = (a * b) % MOD;
        return (int) res;
    }

    // 10 ^ 22 = (10^2 * 10^2 * ... * 10^2) * 10^2
    private long getMod(int powerOfTen) {
        if (powerOfTen < 10) {
            return (long) Math.pow(10, powerOfTen);
        } else {
            long a = getMod(powerOfTen / 10) * 10L % MOD;
            long b = getMod(powerOfTen % 10) % MOD;
            return (a * b) % MOD;
        }
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int answer = solution.countSequences(n);
        System.out.println(answer);
    }
}
/*
2 -> 2
1 -> 0
869121 -> 2511445
 */



/*


009
109
209
309
409
509
609
709
809
909

090
190
290
390
490
590
690
790
890
990

009
019
029
039
049
059
069
079
089
099

900
910
920
930
940
950
960
970
980
990

090
091
092
093
094
095
096
097
098
099

900
901
902
903
904
905
906
907
908
909




 */