package p5517;

import java.util.*;

public class Solution {

    int k;
    Server[] servers;
    int mostFreeServerCompleteTime;
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        this.k = k;
        this.servers = new Server[k];
        this.mostFreeServerCompleteTime = 0;
        for (int i = 0; i < k; i++) {
            this.servers[i] = new Server();
        }

        int n = arrival.length;
        for (int i = 0; i < n; i++) {
            if (arrival[i] < mostFreeServerCompleteTime) {
                // drop
                continue;
            }
            Server assignedServer = assignServer(i, arrival[i]);
            if (assignedServer == null) {
                // drop the request
                continue;
            }
            assignedServer.busyUntil = arrival[i] + load[i];
            assignedServer.handledReqs++;
        }

        List<Integer> answer = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            max = Math.max(max, servers[i].handledReqs);
        }
        for (int i = 0; i < k; i++) {
            if (servers[i].handledReqs == max) {
                answer.add(i);
            }
        }
        return answer;
    }

    private Server assignServer(int idx, int arrival) {
        mostFreeServerCompleteTime = servers[0].busyUntil;
        for (Server server : servers) {
            mostFreeServerCompleteTime = Math.min(mostFreeServerCompleteTime, server.busyUntil);
        }

        int i = idx % k;
        do {
            if (servers[i].busyUntil <= arrival) {
                return servers[i];
            }
            i++;
            if (i == k) {
                i = 0;
            }
        } while (i != idx % k);
        return null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.busiestServers(3, new int[]{1,2,3,4,5}, new int[]{5,2,3,3,3});
    }
}

class Server {
    int handledReqs = 0;
    int busyUntil = 0;
}
