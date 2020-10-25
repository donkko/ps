package p1629;

public class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int longestDuration = releaseTimes[0];
        char largestCharacter = keysPressed.charAt(0);
        for (int i = 1; i < keysPressed.length(); i++) {
            int duration = releaseTimes[i] - releaseTimes[i - 1];
            char c = keysPressed.charAt(i);

            if (duration > longestDuration) {
                longestDuration = duration;
                largestCharacter = c;
            } else if (duration == longestDuration) {
                if (c > largestCharacter) largestCharacter = c;
            }
        }
        return largestCharacter;
    }
}
