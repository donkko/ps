package p844;

public class TwoPointers {
    public boolean backspaceCompare(String S, String T) {
        char[] a = S.toCharArray();
        char[] b = T.toCharArray();

        int aIdx = a.length - 1;
        int bIdx = b.length - 1;
        int aBackspaceCount = 0;
        int bBackspaceCount = 0;

        while (true) {
            if (aIdx < 0 && bIdx < 0) {
                break;
            }

            if (aIdx >= 0) {
                if (a[aIdx] == '#') {
                    aBackspaceCount++;
                    aIdx--;
                    continue;
                }

                if (aBackspaceCount > 0) {
                    aIdx -= 1;
                    aBackspaceCount -= 1;
                    continue;
                }
            }

            if (bIdx >= 0) {
                if (b[bIdx] == '#') {
                    bBackspaceCount++;
                    bIdx--;
                    continue;
                }

                if (bBackspaceCount > 0) {
                    bIdx -= 1;
                    bBackspaceCount -= 1;
                    continue;
                }
            }

            if (aIdx >= 0 && bIdx >= 0) {
                if (a[aIdx] == b[bIdx]) {
                    aIdx--;
                    bIdx--;
                    continue;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
