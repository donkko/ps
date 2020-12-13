package C;

import java.util.*;

public class Main {
    public long solve(long l) {
        return 0;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        long l = (long) scanner.nextInt();

        long answer = solution.solve(l);
        System.out.println(answer);
    }
}
/*
12

-> 1

13

-> 12

14

-> 12*12-12 == 12*11 == 132

17

-> 4368
 */

/*
1 -> 1
* * *

2 -> 3
** * *
* ** *
* * **

3 -> 6 (3개 겹침)
*** * *
** ** *
** * **
* *** *
* ** **
* * ***

4 ->
**** * *
*** ** *
*** * **

*** ** *
** *** *
** ** **

*** * **
** ** **
** * ***

 */

/*
1
* *

2
** *
* **

3
*** *
** **
** **
* ***


 */