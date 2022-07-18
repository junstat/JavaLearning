package Q0099.Q0030SubstringWithConcatenationOfAllWords.solution2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (words.length == 0) return ans;

        int n = s.length(), m = words.length, w = words[0].length();

        // 统计 words 中「每个目标单词」的出现次数
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < w; i++) {
            // 构建一个当前子串对应 map，统计当前子串中「每个目标单词」的出现次数
            Map<String, Integer> curMap = new HashMap<>();
            // 滑动窗口的大小固定是 m * w
            // 每次将下一个单词添加进 cur，上一个单词移出 cur
            for (int j = i; j + w <= n; j += w) {
                String cur = s.substring(j, j + w);
                if (j >= i + (m * w)) {
                    int idx = j - m * w;
                    String prev = s.substring(idx, idx + w);
                    if (curMap.get(prev) == 1) {
                        curMap.remove(prev);
                    } else {
                        curMap.put(prev, curMap.get(prev) - 1);
                    }
                }
                curMap.put(cur, curMap.getOrDefault(cur, 0) + 1);
                // 如果当前子串对应 map 和 words 中对应的 map 相同，说明当前子串包含了「所有的目标单词」，将起始下标加入结果集
                if (map.containsKey(cur) && curMap.get(cur).equals(map.get(cur)) && map.equals(curMap)) {
                    ans.add(j - (m - 1) * w);
                }
            }
        }

        return ans;
    }
}