package Q1799.Q1797DesignAuthenticationManager.solution;

import java.util.*;

public class AuthenticationManager {
    TreeMap<Integer, String> treeMap = new TreeMap<>();
    Map<String, Integer> expireTime = new HashMap<>();
    int ttl;

    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        expireTime.put(tokenId, currentTime + ttl);
        treeMap.put(currentTime + ttl, tokenId);
    }

    public void renew(String tokenId, int currentTime) {
        int expire = expireTime.getOrDefault(tokenId, -1);
        SortedMap<Integer, String> tail = treeMap.tailMap(currentTime + 1);
        if (!tail.isEmpty() && expire >= tail.firstKey()) {
            treeMap.remove(expire);
            treeMap.put(currentTime + ttl, tokenId);
            expireTime.put(tokenId, currentTime + ttl);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        return treeMap.tailMap(currentTime + 1).size();
    }
}
