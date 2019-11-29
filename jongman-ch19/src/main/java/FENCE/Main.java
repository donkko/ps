package FENCE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    // 종만북 코드 그대로 포팅한 것
    int solveStack(List<Integer> h) {
        // 남아 있는 판자들의 위치들을 저장한다.
        Stack<Integer> remaining = new Stack<>();
        h.add(0);
        int ret = 0;
        for(int i = 0; i < h.size(); ++i) {
            // 남아 있는 판자들 중 오른쪽 끝 판자가 h[i]보다 높다면
            // 이 판자의 최대 사각형은 i에서 끝난다.
            while(!remaining.empty() && h.get(remaining.peek()) >= h.get(i)) {
                int j = remaining.pop();
                int width = -1;
                // j번째 판자 왼쪽에 판자가 하나도 안 남아 있는 경우 left[j] = -1
                // 아닌 경우 left[j] = 남아 있는 판자 중 가장 오른쪽에 있는 판자의 번호가 된다.
                if(remaining.empty())
                    width = i;
                else
                    width = (i - remaining.peek() - 1);
                ret = Math.max(ret, h.get(j) * width);
            }
            remaining.push(i);
        }
        return ret;
    }

    class Board {
        Integer idx;
        Integer height;
        Integer left;
        Integer right;

        int getMaxAreaIncludingThisBoard() {
            if (this.height == 0) return 0;
            else return (this.right - this.left - 1) * this.height;
        }
    }

    int solveBoardStack(List<Integer> h) {
        Stack<Board> remaining = new Stack<>();
        h.add(0);
        int ret = 0;
        for(int i = 0; i < h.size(); i++) {
            Board currentBoard = new Board();
            currentBoard.idx = i;
            currentBoard.height = h.get(i);

            if(i == 0) {
                Board minusOneBoard = new Board();
                minusOneBoard.idx = -1;
                minusOneBoard.height = 0;
                minusOneBoard.left = -1;
                remaining.push(minusOneBoard);

                currentBoard.left = -1;
                // currentBoard.right 는 아직 알 수가 없다
                remaining.push(currentBoard);
                continue;
            }

            while(!remaining.empty()) {
                Board stackedBoard = remaining.peek();
                if (stackedBoard.height < currentBoard.height) {
                    currentBoard.left = stackedBoard.idx;
                    // currentBoard.right 는 아직 알 수가 없다
                    break;
                } else {
                    stackedBoard.right = currentBoard.idx;
                    ret = Math.max(ret, stackedBoard.getMaxAreaIncludingThisBoard());
                    remaining.pop(); // 해당 판자를 포함하는 최대 사각형 넓이를 구했으면 스택에서 빼서 버린다
                }
            }
            remaining.push(currentBoard);
        }

        return ret;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for(int i = 0; i < numberOfTests; i++) {
            int numberOfBoards = scanner.nextInt();
            Integer[] heights = new Integer[numberOfBoards];
            for(int j = 0; j < numberOfBoards; j++) {
                heights[j] = scanner.nextInt();
            }

            System.out.println(solution.solveBoardStack(new ArrayList<>(Arrays.asList(heights))));
        }
    }
}
/*
input
3
7
7 1 5 9 6 7 3
7
1 4 4 4 4 1 1
4
1 8 2 2

 */
/*
20
16
8
 */
