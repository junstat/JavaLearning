package Q1699.Q1604AlertUsingSameKeyCardThreeorMoreTimesinaOneHourPeriod.solution;

import java.util.*;

public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, TreeSet<Integer>> nameToTime = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));
            nameToTime.computeIfAbsent(keyName[i], s -> new TreeSet<>()).add(time);
        }
        TreeSet<String> names = new TreeSet<>();
        for (Map.Entry<String, TreeSet<Integer>> e : nameToTime.entrySet()) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int time : e.getValue()) {
                dq.offer(time);
                if (dq.peekLast() - dq.peek() > 60) {
                    dq.poll();
                }
                if (dq.size() >= 3) {
                    names.add(e.getKey());
                    break;
                }
            }
        }
        return new ArrayList<>(names);
    }
}
