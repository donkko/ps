package p136;

import java.util.HashSet;

public class HashTable {
    public int singleNumber(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (hashSet.contains(num)) {
                hashSet.remove(num);
            } else {
                hashSet.add(num);
            }
        }
        return hashSet.iterator().next();
    }
}
