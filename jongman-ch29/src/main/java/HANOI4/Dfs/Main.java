package HANOI4.Dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int n; // 디스크의 총 개수
    static int[] count; // bfs depth를 저장해둘 배열

    static class State {
        int diskState = 0; // 디스크가 어느 기둥에 꽂혀 있는지를 비트로 표현

        public void setDisk(int diskNum, int towerNum) {
            // 해당 diskNum 위치의 기존 towerNum 값 지우기
            this.diskState = this.diskState & ~(3 << (diskNum * 2));

            // 해당 diskNum 위치에 새로운 towerNum 값 넣기
            this.diskState = this.diskState | (towerNum << (diskNum * 2));
        }

        public State newState(int diskNum, int towerNum) {
            State newState = new State();
            newState.diskState = this.diskState;
            newState.setDisk(diskNum, towerNum);
            return newState;
        }

        public int[] getTops() {
            int[] tops = new int[4];
            Arrays.fill(tops, -1);
            int currentDiskNum = 0;
            int currentDiskState = this.diskState;
            while (currentDiskState != 0) {
                int towerNum = currentDiskState & 3;
                if (tops[towerNum] == -1) {
                    tops[towerNum] = currentDiskNum;
                } else {
                    tops[towerNum] = Math.min(tops[towerNum], currentDiskNum);
                }
                currentDiskNum++;
                currentDiskState = currentDiskState >> 2;
            }
            return tops;
        }
    }

    public int solve(State initialState) {
        State finalState = new State();
        for (int diskNum = 0; diskNum < n; diskNum++) {
            finalState.setDisk(diskNum, 3);
        }

        LinkedList<State> queue = new LinkedList<>();
        queue.addLast(initialState);
        count[initialState.diskState] = 0;

        while (!queue.isEmpty()) {
            State state = queue.removeFirst();
            int[] tops = state.getTops();
            for (int towerNumFrom = 0; towerNumFrom < 4; towerNumFrom++) {
                int top = tops[towerNumFrom];
                if (top == -1) continue;
                for (int towerNumTo = 0; towerNumTo < 4; towerNumTo++) {
                    // 같은 기둥으로는 옮길 수 없다
                    if (towerNumFrom == towerNumTo) continue;

                    // 옮기려는 기둥의 맨 위의 원반이 지금 옮기려는 원반보다 번호가 작다면 옮길 수 없다
                    // 옮기려는 기둥이 비어있으면 가능
                    if (tops[towerNumTo] != -1 && tops[towerNumTo] < top) continue;

                    // 원반 옮겨서 새로운 state 생성
                    State newState = state.newState(top, towerNumTo);

                    // 이미 방문했던 state라면 스킵
                    if (count[newState.diskState] != -1) continue;

                    // 최종상태에 도달했다면
                    if (newState.diskState == finalState.diskState) {
                        return count[state.diskState] + 1;
                    }

                    // 아직 방문하지 않은 state라면
                    count[newState.diskState] = count[state.diskState] + 1;
                    queue.addLast(newState);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        System.out.println("Input gogogo");
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            Main.n = scanner.nextInt(); // 원반의 총 수
            Main.count = new int[1 << n * 2];
            Arrays.fill(Main.count, -1);
            State state = new State(); // 디스크의 배치 상태

            int diskCountOfFirstTower = scanner.nextInt();
            for (int j = 0; j < diskCountOfFirstTower; j++) {
                int diskNum = scanner.nextInt();
                state.setDisk(diskNum - 1, 0);
            }

            int diskCountOfSecondTower = scanner.nextInt();
            for (int j = 0; j < diskCountOfSecondTower; j++) {
                int diskNum = scanner.nextInt();
                state.setDisk(diskNum - 1, 1);
            }

            int diskCountOfThirdTower = scanner.nextInt();
            for (int j = 0; j < diskCountOfThirdTower; j++) {
                int diskNum = scanner.nextInt();
                state.setDisk(diskNum - 1, 2);
            }

            int diskCountOfFourthTower = scanner.nextInt();
            for (int j = 0; j < diskCountOfFourthTower; j++) {
                int diskNum = scanner.nextInt();
                state.setDisk(diskNum - 1, 3);
            }

            int answer = solution.solve(state);
            System.out.println(answer);
        }
    }
}
/*
input
3
5
1 1
1 3
2 5 4
1 2
3
1 2
0
2 3 1
0
10
2 8 7
2 5 4
3 6 3 2
3 10 9 1

 */

/*
output
10
4
24
 */
