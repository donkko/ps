package p560;

import java.util.HashMap;

public class HashTable {
    public int subarraySum(int[] nums, int k) {
        var answer = 0;
        var sum = 0;
        var count = new HashMap<Integer, Integer>();
        count.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (count.containsKey(sum - k)) {
                answer += count.get(sum - k);
            }
            count.put(sum, count.getOrDefault(sum, 0) + 1);
        }
        return answer;
    }
}
