package p5535;

public class Solution {

    public int maxDepth(String s) {
        if (s == null || s.isEmpty()) return 0;
        if (s.length() == 1 && !s.equals("(") && !s.equals(")")) return 0;

        int maxDepth = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                depth++;
                maxDepth = Math.max(maxDepth, depth);
            }
            if (c == ')') {
                depth--;
            }
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
    }
}
