package p1046;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Heap {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq =
                new PriorityQueue<>(stones.length, Comparator.reverseOrder());
        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {
            int top1 = pq.poll();
            int top2 = pq.poll();

            if (top1 == top2) {
                continue;
            } else {
                pq.add(top1 - top2);
            }
        }
        if (pq.isEmpty()) return 0;
        else return pq.peek();
    }
}
