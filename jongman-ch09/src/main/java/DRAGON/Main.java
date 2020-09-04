package DRAGON;

import java.util.Scanner;

public class Main {

    int skip;
    int[] length;

    void printPthCharacterOfNthDragonCurve(int n, int p) {
        skip = p - 1;
        length = new int[51];
        precalc();
        curve("FX", n);
    }

    void precalc() {
        length[0] = 1;
        for (int i = 1; i <= 50; i++) {
            length[i] = Math.min(length[i - 1] * 2 + 2, 1000000000);
        }
    }

    void curve(String seed, int generations) {
        if (skip < 0) return;
        if (generations == 0) {
            if (skip >= seed.length()) {
                skip -= seed.length();
            } else {
                System.out.print(seed.charAt(skip));
                skip = -1;
            }
            return;
        }

        for (char c : seed.toCharArray()) {
            if (c == 'X') {
                if (length[generations] <= skip) {
                    skip -= length[generations];
                    continue;
                }
                curve("X+YF", generations - 1);
            } else if (c == 'Y') {
                if (length[generations] <= skip) {
                    skip -= length[generations];
                    continue;
                }
                curve("FX-Y", generations - 1);
            } else {
                if (skip == 0) {
                    System.out.print(c);
                    skip--;
                    return;
                }
                skip--;
            }
        }
    }

    public static void main(String[] args) {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int c = scanner.nextInt(); // 테스트 케이스의 개수
        for (int i = 0; i < c; i++) {
            int n = scanner.nextInt(); // n세대 드래곤 커브 문자열에서
            int p = scanner.nextInt(); // p번째 글자부터
            int l = scanner.nextInt(); // l개의 글자를 출력

            for (int j = 0; j < l; j++) {
                solution.printPthCharacterOfNthDragonCurve(n, p + j);
            }
            System.out.println();
        }
    }
}

/*
0: FX -> 2
1: FX+YF -> 5
2: FX+YF+FX-YF -> 11
3:

gen 0  1   2
len 2  5  11

xLength(n) = "X"를 n세대 진화시킨 결과의 길이
yLength(n) = "Y"를 n세대 진화시킨 결과의 길이

X => X+YF
xLength(2) = xLength(1) + yLength(1) + 2
     10      =    4       +    4       + 2

Y => FX-Y
yLength(1) = xLength(0) + yLength(0) + 2



*/
