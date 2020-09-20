package p5519;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {

    public String reorderSpaces(String text) {
        boolean prevWasSpace = true;
        StringBuilder sb = new StringBuilder();
        int spaceCount = 0;
        List<String> words = new LinkedList<>();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (c == ' ') {
                spaceCount++;
                if (!prevWasSpace) {
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
                prevWasSpace = true;
            } else {
                sb.append(c);
                prevWasSpace = false;
            }
        }
        if (!prevWasSpace) words.add(sb.toString());


        int spaceForOthers = words.size() == 1 ? 0 : spaceCount / (words.size() - 1);
        int spaceForLast = words.size() == 1 ? spaceCount : spaceCount % (words.size() - 1);
        StringBuilder answer = new StringBuilder();
        Iterator<String> iterator = words.iterator();
        answer.append(iterator.next());
        while (iterator.hasNext()) {
            String word = iterator.next();
            for (int i = 0; i < spaceForOthers; i++) answer.append(' ');
            answer.append(word);
        }
        for (int i = 0; i < spaceForLast; i++) answer.append(' ');
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reorderSpaces("  walks  udp package   into  bar a"));
    }
}
