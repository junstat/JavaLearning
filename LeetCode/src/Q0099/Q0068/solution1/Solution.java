package Q0099.Q0068.solution1;

import java.util.ArrayList;
import java.util.List;

/*
    We start with left being the first word.
    findRight: Then we greedily try to go as far right as possible until we fill our current line.
    Then we justify one line at a time.
    justify: In all case we pad the right side with spaces until we reach max width for the line;
    1. If it's one word then it is easy, the result is just that word.
    2. If it's the last line then the result is all words separated by a single space.
    3. Otherwise we calculate the size of each space evenly and if there is a remainder we distribute an extra space
    until it is gone.
 */
public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> result = new ArrayList<>();

        while (left < words.length) {
            int right = findRight(left, words, maxWidth);
            result.add(justify(left, right, words, maxWidth));
            left = right + 1;
        }

        return result;
    }

    private int findRight(int left, String[] words, int maxWidth) {
        int right = left;
        int sum = words[right++].length();

        while (right < words.length && (sum + 1 + words[right].length()) <= maxWidth)
            sum += 1 + words[right++].length();

        return right - 1;
    }

    private String justify(int left, int right, String[] words, int maxWidth) {
        if (right - left == 0) return padResult(words[left], maxWidth);

        boolean isLastLine = right == words.length - 1;
        int numSpace = right - left;
        int totalSpace = maxWidth - wordsLength(left, right, words);

        String space = isLastLine ? " " : blank(totalSpace / numSpace);
        int remainder = isLastLine ? 0 : totalSpace % numSpace;

        StringBuilder result = new StringBuilder();
        for (int i = left; i <= right; i++)
            result.append(words[i])
                    .append(space)
                    .append(remainder-- > 0 ? " " : "");

        return padResult(result.toString().trim(), maxWidth);
    }

    private int wordsLength(int left, int right, String[] words) {
        int wordsLength = 0;
        for (int i = left; i <= right; i++) wordsLength += words[i].length();
        return wordsLength;
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private String blank(int length) {
        return new String(new char[length]).replace('\0', ' ');
    }

}
