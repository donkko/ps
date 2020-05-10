package p997;

import java.util.HashMap;

// Solution 이 도움이 많이 되므로 읽어볼 것
public class HashTable {
    public int findJudge(int N, int[][] trust) {
        if (N == 1) return 1;

        var trustToCount = new HashMap<Integer, Integer>();
        var trustFromCount = new HashMap<Integer, Integer>();

        for (int[] t : trust) {
            int trustFrom = t[0];
            int trustTo = t[1];

            trustToCount.put(trustFrom, trustToCount.getOrDefault(trustFrom, 0) + 1);
            trustFromCount.put(trustTo, trustFromCount.getOrDefault(trustTo, 0) + 1);
        }

        for (int i = 1; i <= N; i++) {
            if (trustToCount.containsKey(i)) {
                continue;
            }
            if (trustFromCount.containsKey(i) && trustFromCount.get(i) == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
