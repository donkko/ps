package day14;

public class StringManipulation {
    public String stringShift(String s, int[][] shift) {
        int totalAmount = 0;
        for (int[] directionAmount : shift) {
            int direction = directionAmount[0];
            int amount = directionAmount[1];
            if (direction == 0) {
                totalAmount -= amount;
            } else {
                totalAmount += amount;
            }

            if (totalAmount >= s.length()) {
                totalAmount = totalAmount % s.length();
            } else if (-totalAmount >= s.length()) {
                totalAmount = -(-totalAmount % s.length());
            }
        }

        if (totalAmount > 0) {
            return s.substring(s.length() - totalAmount, s.length()) + s.substring(0, s.length() - totalAmount);
        } else if (totalAmount < 0) {
            return s.substring(-totalAmount, s.length()) + s.substring(0, -totalAmount);
        } else {
            return s;
        }
    }
}
