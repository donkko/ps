package FIRETRUCKS;

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

    public int dijkstra(List<List<Vertex>> adj, int[] fireSpots) {
        int n = adj.size(); // 정점(vertex)의 개수

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0] = 0; // 시작점은 0

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(v -> v.cost));
        pq.add(new Vertex(0, 0));
        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            // 만약 지금 꺼낸 것보다 더 짧은 경로를 알고 있다면 지금 꺼낸 것을 무시한다
            if (distance[currentVertex.num] < currentVertex.cost) {
                continue;
            }

            // currentVertex와 인접한 정점들을 모두 검사한다
            for (Vertex adjVertex : adj.get(currentVertex.num)) {
                if (adjVertex.num == 0) continue;

                int nextDist;
                if (currentVertex.num == 0) {
                    nextDist = adjVertex.cost;
                } else {
                    nextDist = currentVertex.cost + adjVertex.cost;
                }
                if (distance[adjVertex.num] > nextDist) {
                    distance[adjVertex.num] = nextDist;
                    pq.add(new Vertex(adjVertex.num, nextDist));
                }
            }
        }

        int answer = 0;
        for (int fireSpot : fireSpots) {
            answer += distance[fireSpot];
        }
        return answer;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        System.out.println("Input gogogo");
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int v = scanner.nextInt(); // 장소의 수
            int e = scanner.nextInt(); // 도로의 수
            int n = scanner.nextInt(); // 화재장소의 수
            int m = scanner.nextInt(); // 소방서의 수
            List<List<Vertex>> adj = new ArrayList<>();
            for (int j = 0; j <= v; j++) {
                adj.add(new ArrayList<Vertex>());
            }

            for (int j = 0; j < e; j++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                int weight = scanner.nextInt();
                adj.get(from).add(new Vertex(to, weight));
                adj.get(to).add(new Vertex(from, weight));
            }

            int[] fireSpots = new int[n];
            for (int j = 0; j < n; j++) {
                int fireSpot = scanner.nextInt();
                fireSpots[j] = fireSpot;
            }

            for (int j = 0; j < m; j++) {
                int fireTruck = scanner.nextInt();
                adj.get(0).add(new Vertex(fireTruck, 0));
            }

            int answer = solution.dijkstra(adj, fireSpots);
            System.out.println(answer);
        }
    }
}
/*
input
1
8 12 3 2
1 2 3
1 6 9
2 3 6
3 4 4
3 5 2
4 5 7
6 5 5
8 6 5
6 7 3
8 7 3
7 5 1
2 8 3
2 3 5
4 6

 */

/*
output
16
 */
