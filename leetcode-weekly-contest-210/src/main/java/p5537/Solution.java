package p5537;

public class Solution {

    public boolean checkPalindromeFormation(String a, String b) {
        if (isPalindrome(a, 0, a.length() - 1)) return true;
        if (isPalindrome(b, 0, b.length() - 1)) return true;

        int n = a.length();
        for (int i = 0; i < (n + 1) / 2; i++) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(n - i - 1);
            if (aChar == bChar) {
                if (isPalindrome(b, i + 1, n - i - 2)) return true;
            } else {
                break;
            }
        }
        for (int i = 0; i < (n + 1) / 2; i++) {
            char aChar = a.charAt(n - i - 1);
            char bChar = b.charAt(i);
            if (aChar == bChar) {
                if (isPalindrome(a, i + 1, n - i - 2)) return true;
            } else {
                break;
            }
        }

        a = reverseString(a);
        b = reverseString(b);
        for (int i = 0; i < (n + 1) / 2; i++) {
            char aChar = a.charAt(i);
            char bChar = b.charAt(n - i - 1);
            if (aChar == bChar) {
                if (isPalindrome(b, i + 1, n - i - 2)) return true;
            } else {
                break;
            }
        }
        for (int i = 0; i < (n + 1) / 2; i++) {
            char aChar = a.charAt(n - i - 1);
            char bChar = b.charAt(i);
            if (aChar == bChar) {
                if (isPalindrome(a, i + 1, n - i - 2)) return true;
            } else {
                break;
            }
        }

        return false;
    }

    public static String reverseString(String s) {
        return ( new StringBuffer(s) ).reverse().toString();
    }

    private boolean isPalindrome(String s, int start, int end) {
        int left = start;
        int right = end;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.checkPalindromeFormation(
                "aejbaal flrmkswrydwdkdwdyrwskmrlf qizjezd",
                "uvebspq ckawkhbrtlqwblfwzfptanhig laabjea"
        );
    }
}

/*
"abcde"
"xyzba"

"abcd"
"xyza"


 */