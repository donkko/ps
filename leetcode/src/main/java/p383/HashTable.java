package p383;

import java.util.HashMap;

public class HashTable {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) return true;
        if (magazine == null || magazine.length() == 0) return false;
        if (ransomNote.length() > magazine.length()) return false;

        var charMap = new HashMap<Character, Integer>();
        for (char c : magazine.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (charMap.containsKey(c)) {
                int count = charMap.get(c);
                if (count == 0) {
                    return false;
                } else {
                    charMap.put(c, count - 1);
                }
            } else {
                return false;
            }
        }

        return true;
    }
}
