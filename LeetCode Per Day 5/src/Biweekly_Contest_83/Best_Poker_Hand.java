package Biweekly_Contest_83;

import java.util.HashMap;

public class Best_Poker_Hand {

//    "Flush": Five cards of the same suit.
//            "Three of a Kind": Three cards of the same rank.
//            "Pair": Two cards of the same rank.
//            "High Card": Any single card.

    public String bestHand(int[] ranks, char[] suits) {
        int[] arr = new int[5];
        for (char a : suits) {
            arr[a - 'a']++;
            if (arr[a - 'a'] > 4)
                return "Flush";
        }

        HashMap<Integer, Integer> map = new HashMap();
        for (int rank : ranks) {
            map.put(rank, map.getOrDefault(rank, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 2) {
                return "Three of a Kind";
            }
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 1) {
                return "Pair";
            }
        }
        return "High Card";

    }

}
