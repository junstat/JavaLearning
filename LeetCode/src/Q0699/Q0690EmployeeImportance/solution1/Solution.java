package Q0699.Q0690EmployeeImportance.solution1;

import Q0699.Q0690EmployeeImportance.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, Employee> map = new HashMap<>();

    public int getImportance(List<Employee> es, int id) {
        int n = es.size();
        for (int i = 0; i < n; i++) map.put(es.get(i).id, es.get(i));
        return getVal(id);
    }

    int getVal(int id) {
        Employee master = map.get(id);
        int ans = master.importance;
        for (int oid : master.subordinates) {
            Employee other = map.get(oid);
            ans += other.importance;
            for (int sub : other.subordinates) ans += getVal(sub);
        }
        return ans;
    }
}