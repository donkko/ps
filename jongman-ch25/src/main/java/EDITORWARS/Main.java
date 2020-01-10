package EDITORWARS;

import java.util.Scanner;

public class Main {
    static class BipartiteUnionFind {
        int n;
        int parent[];
        int rank[];
        int enemy[];
        int size[];

        BipartiteUnionFind(int n) {
            this.n = n;
            parent = new int[n]; for(int i=0;i<n;++i) parent[i] = i;
            rank = new int[n]; for(int i=0;i<n;++i) rank[i] = 0;
            enemy = new int[n]; for(int i=0;i<n;++i) enemy[i] = -1;
            size = new int[n]; for(int i=0;i<n;++i) size[i] = 1;
        }

        int find(int u) {
            if (parent[u] == u) return u;
            parent[u] = find(parent[u]);
            return parent[u];
        }

        int union(int u, int v) {
            // u 나 v 가 공집합인 경우 나머지 하나를 반환한다.
            if (u == -1 || v == -1) return Math.max(u, v);
            u = find(u);
            v = find(v);

            // 이미 둘이 같은 트리에 속한 경우
            if (u == v) return u;

            if (rank[u] > rank[v]) swap(u, v);
            if (rank[u] == rank[v]) rank[v]++;
            parent[u] = v;
            size[v] += size[u];
            return v;
        }

        void swap(int u, int v) {
            int temp = u;
            u = v;
            v = temp;
        }

        // u 와 v 가 서로 적이다. 모순이 일어났다면 false, 아니면 true 를 반환한다.
        boolean dis(int u, int v) {
            // 우선 루트를 찾는다.
            u = find(u);
            v = find(v);

            // 같은 집합에 속해 있으면 모순!
            if (u == v) return false;

            // 적의 적은 나의 동지
            int a = union(u, enemy[v]);
            int b = union(v, enemy[u]);
            enemy[a] = b;
            enemy[b] = a;

            return true;
        }

        // u 와 v 가 서로 동지다. 모순이 일어났다면 false, 아니면 true 를 반환한다.
        boolean ack(int u, int v) {
            // 우선 루트를 찾는다.
            u = find(u);
            v = find(v);

            // 두 집합이 서로 적대 관계라면 모순!
            if (enemy[u] == v) return false;

            // 동지의 적은 나의 적
            int a = union(u, v);
            int b = union(enemy[u], enemy[v]);
            enemy[a] = b;

            // 두 집합 다 적대하는 집합이 없으면 b는 -1일 수도 있다.
            if (b != -1) enemy[b] = a;

            return true;
        }
    }

    int maxParty(BipartiteUnionFind buf) {
        int ret = 0;
        for (int node = 0; node < buf.n; ++node) {
            if (buf.parent[node] == node) {
                int enemy = buf.enemy[node];

                // 같은 모임 쌍을 두 번 세지 않기 위해, enemy < node 인 경우만 센다.
                // enemy == -1 인 경우도 정확히 한번씩 세게 된다.
                if (enemy > node) continue;
                int mySize = buf.size[node];
                int enemySize = (enemy == -1 ? 0 : buf.size[enemy]);

                // 두 집합 중 큰 집합을 더한다.
                ret += Math.max(mySize, enemySize);
            }
        }
        return ret;
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();
        for (int i = 0; i < numberOfTests; i++) {
            int n = scanner.nextInt(); // 회원의 수
            int m = scanner.nextInt(); // 댓글의 수

            BipartiteUnionFind buf = new BipartiteUnionFind(n);
            boolean isContradiction = false;
            int lineNumOfContradiction = 0;
            for (int j = 0; j < m; j++) {
                String type = scanner.next().trim();
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                if (type.equals("ACK")) {
                    boolean result = buf.ack(a, b);
                    if (result == false) {
                        isContradiction = true;
                        if (lineNumOfContradiction == 0) lineNumOfContradiction = j + 1;
                    }
                } else {
                    boolean result = buf.dis(a, b);
                    if (result == false) {
                        isContradiction = true;
                        if (lineNumOfContradiction == 0) lineNumOfContradiction = j + 1;
                    }
                }
            }
            if (isContradiction) {
                System.out.println("CONTRADICTION AT " + lineNumOfContradiction);
            } else {
                System.out.println("MAX PARTY SIZE IS " + solution.maxParty(buf));
            }
        }
    }
}

/*
input
4
4 4
ACK 0 1
ACK 1 2
DIS 1 3
ACK 2 0
100 4
ACK 0 1
ACK 1 2
ACK 2 3
ACK 3 4
3 3
ACK 0 1
ACK 1 2
DIS 2 0
8 6
DIS 0 1
ACK 1 2
ACK 1 4
DIS 4 3
DIS 5 6
ACK 5 7

 */
/*
output
MAX PARTY SIZE IS 3
MAX PARTY SIZE IS 100
CONTRADICTION AT 3
MAX PARTY SIZE IS 5
 */
