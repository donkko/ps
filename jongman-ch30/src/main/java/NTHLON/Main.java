package NTHLON;

import java.util.*;

public class Main {
    static class Vertex {
        Vertex(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
        int num;
        int cost;
    }

    static public int actualVertexNum(int delta) {
        // delta 값은 범위는 -199 ~ +199
        return delta + 200;
    }

    public List<List<Vertex>> makeGraph(int[] aTimes, int[] bTimes) {
        int sportsCount = aTimes.length; // 운동종목 수
        int vertexCount = 402; // -200 ~ 200 그리고 시작점
        int rootVertexNum = 401;

        List<List<Vertex>> adj = new ArrayList<>();
        for (int i = 0; i < vertexCount; i++) {
            adj.add(new ArrayList<Vertex>());
        }

        // 루트와 인접하는 정점 만들기
        for (int i = 0; i < sportsCount; i++) {
            int delta = aTimes[i] - bTimes[i];
            adj.get(rootVertexNum).add(new Vertex(actualVertexNum(delta), aTimes[i]));
        }

        // 현재 차이
        for (int delta = -200; delta <= 200; delta++) {
            // i번 종목을 뒤에 붙인다면?
            for (int i = 0; i < aTimes.length; i++) {
                int next = delta + (aTimes[i] - bTimes[i]);
                // 시간 차이가 200을 넘는 정점은 만들 필요가 없다
                if (next < -200 || 200 < next) {
                    continue;
                }
                adj.get(actualVertexNum(delta)).add(new Vertex(actualVertexNum(next), aTimes[i]));
            }
        }
        return adj;
    }

    public int dijkstra(List<List<Vertex>> adj) {
        int n = adj.size(); // 정점(vertex)의 개수

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[401] = 0; // 시작점은 401

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.cost));
        pq.add(new Vertex(401, 0));
        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            // 만약 지금 꺼낸 것보다 더 짧은 경로를 알고 있다면 지금 꺼낸 것을 무시한다
            if (distance[currentVertex.num] < currentVertex.cost) {
                continue;
            }

            // currentVertex와 인접한 정점들을 모두 검사한다
            for (Vertex adjVertex : adj.get(currentVertex.num)) {
                int nextDist = currentVertex.cost + adjVertex.cost;
                if (distance[adjVertex.num] > nextDist) {
                    distance[adjVertex.num] = nextDist;
                    pq.add(new Vertex(adjVertex.num, nextDist));
                }
            }
        }

        return distance[actualVertexNum(0)];
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        System.out.println("Input gogogo");
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int m = scanner.nextInt(); // 채택 가능한 종목의 수

            int[] aTimes = new int[m];
            int[] bTimes = new int[m];
            for (int j = 0; j < m; j++) {
                aTimes[j] = scanner.nextInt();
                bTimes[j] = scanner.nextInt();
            }

            List<List<Vertex>> adj = solution.makeGraph(aTimes, bTimes);
            int answer = solution.dijkstra(adj);
            if (answer == Integer.MAX_VALUE) {
                System.out.println("IMPOSSIBLE");
            } else {
                System.out.println(answer);
            }
        }
    }
}
/*
input
3
5
1 2
3 4
5 6
7 8
7 3
3
1 100
21 20
10 1
3
10 81
63 71
16 51

 */

/*
output
11
111
IMPOSSIBLE
 */
