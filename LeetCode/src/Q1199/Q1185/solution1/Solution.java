package Q1199.Q1185.solution1;

import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Solution {
    @Test
    public void test1() {
        int day = 31, month = 8, year = 2019;
        assertThat(dayOfTheWeek(day, month, year), equalTo("Saturday"));
    }

    @Test
    public void test2() {
        int day = 18, month = 7, year = 1999;
        assertThat(dayOfTheWeek(day, month, year), equalTo("Sunday"));
    }

    @Test
    public void test3() {
        int day = 15, month = 8, year = 1993;
        assertThat(dayOfTheWeek(day, month, year), equalTo("Sunday"));
    }

    static final String[] WEEK_NAMES = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate date = LocalDate.of(year, month, day);
        return WEEK_NAMES[date.getDayOfWeek().getValue() - 1];
    }
}
