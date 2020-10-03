package p5516;

import java.util.*;

public class Solution {

    public List<String> alertNames(String[] keyName, String[] keyTime) {
        int n = keyName.length;
        Map<String, List<Integer>> nameTimeMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String name = keyName[i];
            String timeStr = keyTime[i];
            timeStr = timeStr.replace(":", "");
            int time = Integer.parseInt(timeStr);

            List<Integer> timeList = nameTimeMap.getOrDefault(name, new ArrayList<>());
            timeList.add(time);
            nameTimeMap.put(name, timeList);
        }

        List<String> answer = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : nameTimeMap.entrySet()) {
            List<Integer> timeList = entry.getValue();
            timeList.sort((a, b) -> a - b);
            if (alertRequired(timeList)) {
                answer.add(entry.getKey());
            }
        }
        answer.sort((a, b) -> a.compareTo(b));
        return answer;
    }

    private boolean alertRequired(List<Integer> timeList) {
        for (int i = 0; i < timeList.size(); i++) {
            int time = timeList.get(i);
            int count = 1;
            for (int j = i + 1; j < timeList.size(); j++) {
                if (time + 100 < timeList.get(j)) {
                    break;
                }
                if (timeList.get(j) <= time + 100) {
                    count++;
                }
                if (count == 3) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.alertNames(
                new String[] {"daniel","daniel","daniel","luis","luis","luis","luis"},
                new String[] {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}
        ));
        System.out.println(solution.alertNames(
                new String[] {"alice","alice","alice","bob","bob","bob","bob"},
                new String[] {"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}
        ));
        System.out.println(solution.alertNames(
                new String[] {"john","john","john"},
                new String[] {"23:58","23:59","00:01"}
        ));
        System.out.println(solution.alertNames(
                new String[] {"leslie","leslie","leslie","clare","clare","clare","clare"},
                new String[] {"13:00","13:20","14:00","18:00","18:51","19:30","19:49"}
        ));
    }
}
