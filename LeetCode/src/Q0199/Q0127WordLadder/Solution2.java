package Q0199.Q0127WordLadder;

import java.util.*;

public class Solution2 {
    String s, e;
    Set<String> set;

    public int ladderLength(String _s, String _e, List<String> ws) {
        s = _s;
        e = _e;
        // 将所有word存入set，若目标单词不在set中，说明无解
        set = new HashSet<>(ws);
        if (!set.contains(e)) return 0;
        int ans = bfs();
        return ans == -1 ? 0 : ans + 1;
    }

    int bfs() {
        // d1代表从起点beginWord开始搜索(正向)
        // d2代表从结尾endWord开始搜索(反向)
        Deque<String> d1 = new ArrayDeque<>(), d2 = new ArrayDeque<>();

        // m1 和 m2 分别记录两个方向出现的
        // e.g.
        // m1 = {"abc":1} 代表abc 由beginWord替换1次字符而来
        // m2 = {"xyz":3} 代表xyz 由endWord替换3次字符而来
        Map<String, Integer> m1 = new HashMap<>(), m2 = new HashMap<>();
        d1.add(s);
        m1.put(s, 0);
        d2.add(e);
        m2.put(e, 0);

        /*
         * 只有两个队列都不空了，才有必要继续往下搜索
         * 若其中一个队列空了，说明从某个方向搜到底都搜不到该方向的目标节点
         * e.g.
         * 例如，若d1为空了，说明从beginWord搜索到底都搜索不到endWord，反向搜索也没必要进行了
         */
        while (!d1.isEmpty() && !d2.isEmpty()) {
            int t = -1;
            // 为了让两个方向的搜索尽可能平均，优先拓展队列内元素少的方向
            if (d1.size() <= d2.size()) t = update(d1, m1, m2);
            else t = update(d2, m2, m1);
            if (t != -1) return t;
        }
        return -1;
    }

    // update 代表从deque中取出一个单词进行扩展
    int update(Deque<String> deque, Map<String, Integer> cur, Map<String, Integer> other) {
        int m = deque.size();
        while (m-- > 0) {
            // 获取当前需要扩展的原字符串
            String poll = deque.pollFirst();
            int n = poll.length();

            // 枚举替换原字符串的哪个字符i
            for (int i = 0; i < n; i++) {
                // 枚举将i替换成哪个小写字母
                for (int j = 0; j < 26; j++) {
                    // 替换后的字符串
                    String sub = poll.substring(0, i) + String.valueOf((char) ('a' + j)) + poll.substring(i + 1);
                    if (set.contains(sub)) {
                        // 若该字符串在「当前方向」被记录过(拓展过)，跳过即可
                        if (cur.containsKey(sub) && cur.get(sub) <= cur.get(poll) + 1) continue;
                        // 若该字符串在「另一方向」出现过，说明找到了联通两个方向的最短路
                        if (other.containsKey(sub)) {
                            return cur.get(poll) + 1 + other.get(sub);
                        } else {
                            // 否则加入deque队列
                            deque.addLast(sub);
                            cur.put(sub, cur.get(poll) + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }
}