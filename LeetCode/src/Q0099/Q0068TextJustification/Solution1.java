package Q0099.Q0068TextJustification;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words.length == 0 || maxWidth == 0) {
            result.add("");
            return result;
        }

        for (int i = 0, w; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= maxWidth; w++)
                len += words[w].length() + 1;

            int evenlyDistributedSpaces = 1;
            int extraSpaces = 0;
            int numOfGapsBwWords = w - i - 1;

            if (w != i + 1 && w != words.length) {
                evenlyDistributedSpaces = ((maxWidth - len) / numOfGapsBwWords) + 1;
                extraSpaces = (maxWidth - len) % numOfGapsBwWords;
            }

            StringBuilder sb = new StringBuilder(words[i]);
            for (int j = i + 1; j < w; j++) {
                for (int s = 0; s < evenlyDistributedSpaces; s++)
                    sb.append(' ');
                if (extraSpaces > 0) {
                    sb.append(' ');
                    extraSpaces--;
                }
                sb.append(words[j]);
            }

            int remaining = maxWidth - sb.length();
            while (remaining > 0) {
                sb.append(' ');
                remaining--;
            }
            result.add(sb.toString());
        }
        return result;
    }
}