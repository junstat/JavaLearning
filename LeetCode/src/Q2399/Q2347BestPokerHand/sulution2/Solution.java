package Q2399.Q2347BestPokerHand.sulution2;

public class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        int[] cards = new int[13];
        cards[ranks[0] - 1]++;
        char lastSuit = suits[0];
        boolean isFlush = true;
        int sameCard = 1;
        for (int i = 1; i != 5; i++) {
            if (suits[i] != lastSuit)
                isFlush = false;
            cards[ranks[i] - 1]++;
            if (cards[ranks[i] - 1] > sameCard)
                sameCard = cards[ranks[i] - 1];
        }
        if (isFlush)
            return "Flush";
        switch (sameCard) {
            case 4:
            case 3:
                return "Three of a Kind";
            case 2:
                return "Pair";
            default:
                return "High Card";
        }
    }
}