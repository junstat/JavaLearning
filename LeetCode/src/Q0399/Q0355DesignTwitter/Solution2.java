package Q0399.Q0355DesignTwitter;

import java.util.*;

public class Solution2 {
}

// Runtime: 8 ms, faster than 99.80% of Java online submissions for Design Twitter.
class Twitter2 {

    private List<Integer[]> posts;
    private Map<Integer, Set<Integer>> relation;

    public Twitter2() {
        this.posts = new ArrayList<>();
        this.relation = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        this.posts.add(new Integer[]{userId, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();
        for (int idx = this.posts.size() - 1; idx >= 0 && newsFeed.size() < 10; idx--) {
            Integer[] post = this.posts.get(idx);
            Set<Integer> followees = this.relation.get(userId);
            if (post[0] == userId || (followees != null && followees.contains(post[0]))) {
                newsFeed.add(post[1]);
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = this.relation.get(followerId);
        if (followees == null) {
            followees = new HashSet<>();
        }
        followees.add(followeeId);
        this.relation.put(followerId, followees);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = this.relation.get(followerId);
        if (followees != null) {
            followees.remove(followeeId);
        }
    }
}
