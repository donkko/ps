package p49;

import java.util.*;

public class HashTable {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strCountmap = new HashMap<>();
        for (String str : strs) {
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (char c : str.toCharArray()) {
                if (charCountMap.containsKey(c)) {
                    charCountMap.put(c, charCountMap.get(c) + 1);
                } else {
                    charCountMap.put(c, 1);
                }
            }
            String charCountStr = makeCharCountStr(charCountMap);
            if (strCountmap.containsKey(charCountStr)) {
                strCountmap.get(charCountStr).add(str);
            } else {
                List<String> strList = new LinkedList<>();
                strList.add(str);
                strCountmap.put(charCountStr, strList);
            }
        }

        return new LinkedList<>(strCountmap.values());
    }

    public static String makeCharCountStr(Map<Character, Integer> charCountMap) {
        StringBuilder sb = new StringBuilder();
        for (int i = 'a'; i <= 'z'; i++) {
            sb.append((char) i);
            sb.append(charCountMap.getOrDefault((char) i, 0));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('g', 999);
        System.out.println(HashTable.makeCharCountStr(m));
    }
}
