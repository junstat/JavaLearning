package Q0199.Q0168ExcelSheetColumnTitle;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/*
    [Easy]
    Given an integer columnNumber, return its corresponding column title as it appears in an Excel sheet.
    For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28
    ...

    Example 1:
    Input: columnNumber = 1
    Output: "A"

    Example 2:
    Input: columnNumber = 28
    Output: "AB"

    Example 3:
    Input: columnNumber = 701
    Output: "ZY"
 */
public class Review {

    @Test
    public void test1() {
        assertEquals("ZY", convertToTitle(701));
    }

    public String convertToTitle(int columnNumber) {

        return null;
    }
}
