package p5520;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Solution {

    public int maxUniqueSplit(String s) {
        LinkedList<String> result = new LinkedList<>();
        Set<String> hashSet = new HashSet<>();
        String floatingWord = null;

        result.add(String.valueOf(s.charAt(0)));
        hashSet.add(String.valueOf(s.charAt(0)));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);

            if (floatingWord == null) {
                if (!hashSet.contains(String.valueOf(c))) {
                    hashSet.add(String.valueOf(c));
                    result.add(String.valueOf(c));
                    continue;
                }

                String lastWord = result.getLast();
                String lastWordPlusC = result.getLast() + c;
                if (!hashSet.contains(lastWordPlusC)) {
                    hashSet.remove(lastWord);
                    hashSet.add(lastWordPlusC);
                    result.removeLast();
                    result.addLast(lastWordPlusC);
                    continue;
                }

                floatingWord = String.valueOf(c);
                continue;
            } else {
                String floatingWordPlusC = floatingWord + c;
                if (!hashSet.contains(floatingWordPlusC)) {
                    hashSet.add(floatingWordPlusC);
                    result.addLast(floatingWordPlusC);
                    floatingWord = null;
                } else {
                    floatingWord = floatingWordPlusC;
                }
            }
        }
        if (floatingWord != null) {
            return 0;
        } else {
            return result.size();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxUniqueSplit("gahbag"));
    }
}
