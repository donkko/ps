package ROUTING;

import java.util.*;

public class Main {
    static class Vertex {
        Vertex(int num, double cost) {
            this.num = num;
            this.cost = cost;
        }
        int num;
        double cost;
    }

    public double dijkstra(List<List<Vertex>> adj) {
        int n = adj.size(); // 정점(vertex)의 개수

        double[] distance = new double[n];
        Arrays.fill(distance, Double.MAX_VALUE);
        distance[0] = 0.0; // 시작점은 0

        PriorityQueue<Vertex> pq = new PriorityQueue<>(Comparator.comparingDouble(v -> v.cost));
        pq.add(new Vertex(0, 0.0));
        while (!pq.isEmpty()) {
            Vertex currentVertex = pq.poll();

            // 만약 지금 꺼낸 것보다 더 짧은 경로를 알고 있다면 지금 꺼낸 것을 무시한다
            if (distance[currentVertex.num] < currentVertex.cost) {
                continue;
            }

            // currentVertex와 인접한 정점들을 모두 검사한다
            for (Vertex adjVertex : adj.get(currentVertex.num)) {
                if (adjVertex.num == 0) continue;

                double nextDist;
                if (currentVertex.num == 0) {
                    nextDist = adjVertex.cost;
                } else {
                    nextDist = currentVertex.cost * adjVertex.cost;
                }
                if (distance[adjVertex.num] > nextDist) {
                    distance[adjVertex.num] = nextDist;
                    pq.add(new Vertex(adjVertex.num, nextDist));
                }
            }
        }

        return distance[n - 1]; // 제일 마지막 정점까지의 최단 거리
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        System.out.println("Input gogogo");
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int n = scanner.nextInt(); // 컴퓨터의 수
            int m = scanner.nextInt(); // 회선의 수
            List<List<Vertex>> adj = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                adj.add(new ArrayList<Vertex>());
            }

            for (int j = 0; j < m; j++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                double weight = scanner.nextDouble();
                adj.get(from).add(new Vertex(to, weight));
                adj.get(to).add(new Vertex(from, weight));
            }

            double answer = solution.dijkstra(adj);
            System.out.println(answer);
        }
    }
}
/*
input
1
7 14
0 1 1.3
0 2 1.1
0 3 1.24
3 4 1.17
3 5 1.24
3 1 2
1 2 1.31
1 2 1.26
1 4 1.11
1 5 1.37
5 4 1.24
4 6 1.77
5 6 1.11
2 6 1.2

 */

/*
output
1.3200000000

 */
