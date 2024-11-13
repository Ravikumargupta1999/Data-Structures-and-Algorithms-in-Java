import java.util.ArrayList;
import java.util.Collections;




//        similar question on leet code ->
//
//        1552. Magnetic Force Between Two Balls
//        1870. Minimum Speed to Arrive on Time
//        875. Koko Eating Bananas
//        1011. Capacity To Ship Packages Within D Days
//        1283. Find the Smallest Divisor Given a Threshold
//        1482. Minimum Number of Days to Make m Bouquets
//        2064. Minimized Maximum of Products Distributed to Any Store




//        More Good Binary Search Problems (Leet code).
//        Good luck and have fun!
//
//        1539. Kth Missing Positive Number
//        1482. Minimum Number of Days to Make m Bouquets
//        1283. Find the Smallest Divisor Given a Threshold
//        1231. Divide Chocolate
//        1011. Capacity To Ship Packages In N Days
//        875. Koko Eating Bananas
//        774. Minimize Max Distance to Gas Station
//        410. Split Array Largest Sum


public class Searching_Sorting_124_Aggressive_Cows {

    // https://www.youtube.com/watch?v=wSOfYesTBRk
    // https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559?leftPanelTab=1

    //        similar question on leet code ->
//
//        1552. Magnetic Force Between Two Balls
//        1870. Minimum Speed to Arrive on Time
//        875. Koko Eating Bananas
//        1011. Capacity To Ship Packages Within D Days
//        1283. Find the Smallest Divisor Given a Threshold
//        1482. Minimum Number of Days to Make m Bouquets
//        2064. Minimized Maximum of Products Distributed to Any Store
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) {
        //    Write your code here.
        Collections.sort(stalls);
        int low = 1;
        int high = stalls.get(stalls.size() - 1) - stalls.get(0);

        int res = -1;
        while (low <= high) {

            int mid = (low + high) /2;

            if (canPlaced(stalls, mid,k)) {
                res = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return res;
    }

    public static boolean canPlaced(ArrayList<Integer> stalls, int distance,int k) {

        int coordinate = stalls.get(0);
        int count = 1;

        for (int i = 1; i < stalls.size(); i++) {
            if (stalls.get(i) - coordinate >= distance) {
                count++;
                coordinate = stalls.get(i);
            }
            if(count == k)
                return true;
        }
        return false;
    }
}
