package day28;

import java.util.*;

class FirstUnique {
    Set<Integer> allNums;
    Set<Integer> uniqueNums;

    public FirstUnique(int[] nums) {
        allNums = new HashSet<>();
        uniqueNums = new LinkedHashSet<>();
        for (int num : nums) {
            this.add(num);
        }
    }

    public int showFirstUnique() {
        if (uniqueNums.isEmpty()) {
            return -1;
        } else {
            return uniqueNums.iterator().next();
        }
    }

    public void add(int value) {
        if (allNums.contains(value)) {
            uniqueNums.remove(value);
        } else {
            allNums.add(value);
            uniqueNums.add(value);
        }
    }

    public static void main(String[] args) {

    }
}
