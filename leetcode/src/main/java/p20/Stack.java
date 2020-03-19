package p20;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Stack {
    Map<Character, Integer> open = new HashMap<>();
    {
        open.put('(', 1);
        open.put('{', 2);
        open.put('[', 3);
    }

    Map<Character, Integer> close = new HashMap<>();
    {
        close.put(')', 1);
        close.put('}', 2);
        close.put(']', 3);
    }

    private boolean isOpen(char c) {
        return open.containsKey(c);
    }

    private boolean isClose(char c) {
        return close.containsKey(c);
    }

    public boolean isValid(String s) {
        if (s.isEmpty()) {
            return true;
        }

        char[] chars = s.toCharArray();
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];

            if (stack.size() == 0) {
                if (isClose(current)) return false;

                stack.push(current);
                continue;
            }

            if (isOpen(current)) {
                stack.push(current);
                continue;
            }

            int openType = open.get(stack.peekFirst());
            int closeType = close.get(current);

            if (openType == closeType) {
                stack.pop();
                continue;
            } else {
                return false;
            }
        }

        if (stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}
