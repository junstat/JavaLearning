package Q0699.Q0690EmployeeImportance.solution2;

import Q0699.Q0690EmployeeImportance.Employee;

import java.util.*;

public class Solution {
    public int getImportance(List<Employee> es, int id) {
        int n = es.size();
        Map<Integer, Employee> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(es.get(i).id, es.get(i));
        int ans = 0;
        Deque<Employee> d = new ArrayDeque<>();
        d.addLast(map.get(id));
        while (!d.isEmpty()) {
            Employee poll = d.pollFirst();
            ans += poll.importance;
            for (int oid : poll.subordinates) {
                d.addLast(map.get(oid));
            }
        }
        return ans;
    }
}