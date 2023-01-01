package Q0899.Q0855ExamRoom.solution;

import java.util.TreeSet;

public class ExamRoom {
    int n;
    TreeSet<Integer> students;

    public ExamRoom(int _n) {
        n = _n;
        students = new TreeSet<>();
    }

    public int seat() {
        int student = 0;
        if (students.size() > 0) {
            int dist = students.first();
            Integer prev = null;
            for (Integer s : students) {
                if (prev != null) {
                    int d = (s - prev) / 2;
                    if (d > dist) {
                        dist = d;
                        student = prev + d;
                    }
                }
                prev = s;
            }
            if (n - 1 - students.last() > dist)
                student = n - 1;
        }

        students.add(student);
        return student;
    }

    public void leave(int p) {
        students.remove(p);
    }
}