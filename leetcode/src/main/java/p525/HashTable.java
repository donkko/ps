package p525;

import java.util.HashMap;

public class HashTable {
    public int findMaxLength(int[] nums) {
        int count = 0;
        int maxLength = 0;
        var indexMap = new HashMap<Integer, Integer>();
        indexMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else count--;

            if (indexMap.containsKey(count)) {
                int length = i - indexMap.get(count);
                if (length > maxLength) {
                    maxLength = length;
                }
            } else {
                indexMap.put(count, i);
            }
        }

        return maxLength;
    }
}
