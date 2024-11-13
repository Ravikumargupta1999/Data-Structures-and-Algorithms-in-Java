import java.util.HashMap;
// https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/submissions/
public class Video_50_X_of_a_Kind_in_a_Deck_of_Cards {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < deck.length; i++)
            map.put(deck[i], map.getOrDefault(deck[i], 0) + 1);

        // Ye bhi sahi hai
//        if (map.size() == 1) {
//            if (map.get(deck[0]) < 2)
//                return false;
//            else
//                return true;
//        }
//        int[] arr = new int[map.size()];
//        int i = 0;
//        for (int key : map.keySet())
//            arr[i++] = map.get(key);
//        int gcd = gcd(arr[0], arr[1]);
//        for (int j = 2; j < arr.length; j++)
//            gcd = gcd(gcd, arr[j]);
//        return gcd > 1 ? true : false;

        int ans = 0;
        for (int key : map.keySet())
            ans = gcd(ans,map.get(key));
        if(ans >= 2)
            return true;
        else
            return false;
    }

    public int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

}
