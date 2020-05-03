package p1426;

import java.util.HashSet;

// 너무 쉬운데 -_-
public class HashTable {
    public int countElements(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : arr) {
            hs.add(num);
        }

        int count = 0;
        for (int num : arr) {
            if (hs.contains(num + 1)) {
                count++;
            }
        }

        return count;
    }
}
