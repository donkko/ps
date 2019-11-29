package BRACKETS2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    Map<Character, Integer> opening = new HashMap<>();
    Map<Character, Integer> closing = new HashMap<>();
    { opening.put('(', 1); opening.put('{', 2); opening.put('[', 3);
      closing.put(')', 1); closing.put('}', 2); closing.put(']', 3); }

    boolean isOpening(char character) { return opening.get(character) != null; }
    boolean isClosing(char character) { return closing.get(character) != null; }
    boolean isPair(char a, char b) { return opening.get(a).equals(closing.get(b)); }

    boolean wellMatched(char[] formula) {
        // 이미 열린 괄호들을 순서대로 담는 스택
        Stack<Character> openStack = new Stack<>();
        for(int i = 0; i < formula.length; ++i) {
            // 여는 괄호인지 닫는 괄호인지 확인한다
            if(isOpening(formula[i])) {
                // 여는 괄호라면 무조건 스택에 집어넣는다.
                openStack.push(formula[i]);
            }
            else {
                // 이 외의 경우 스택 맨 위의 문자와 맞춰보자.
                // 스택이 비어 있는 경우에는 실패
                if(openStack.empty()) return false;

                // 서로 짝이 맞지 않아도 실패
                if(!isPair(openStack.peek(), formula[i])) return false;

                // 짝을 맞춘 괄호는 스택에서 뺀다.
                openStack.pop();
            }
        }

        // 닫히지 않은 괄호가 없어야 성공
        return openStack.empty();
    }

    public static void main(String[] args) throws Exception {
        Main solution = new Main();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTests = Integer.parseInt(reader.readLine().trim());

        for(int i = 0; i < numberOfTests; i++) {
            char[] formula = reader.readLine().trim().toCharArray();
            boolean result = solution.wellMatched(formula);
            if (result) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

/*
input
3
()()
({[}])
({}[(){}])

 */
/*
output
YES
NO
YES
 */
