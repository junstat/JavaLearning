package Q0199.Q0187RepeatedDNASequences;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/*
    [Medium]
    The DNA sequence is composed of a series of nucleotides abbreviated as 'A', 'C', 'G', and 'T'.
    For example, "ACGAATTCCG" is a DNA sequence.
    When studying DNA, it is useful to identify repeated sequences within the DNA.
    Given a string s that represents a DNA sequence, return all the 10-letter-long sequences (substrings) that occur
    more than once in a DNA molecule. You may return the answer in any order.

    Example 1:
    Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
    Output: ["AAAAACCCCC","CCCCCAAAAA"]

    Example 2:
    Input: s = "AAAAAAAAAAAAA"
    Output: ["AAAAAAAAAA"]
 */
public class Review {

    @Test
    public void test1() {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = findRepeatedDnaSequences(s);
        List<String> expected = new ArrayList<>(Arrays.asList("AAAAACCCCC", "CCCCCAAAAA"));
        for (int i = 0; i < result.size(); i++) {
            assertEquals(expected.get(i), result.get(i));
        }
    }

    public List<String> findRepeatedDnaSequences(String s) {

        return null;
    }
}
