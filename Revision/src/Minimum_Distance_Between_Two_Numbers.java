// https://practice.geeksforgeeks.org/problems/minimum-distance-between-two-numbers/1/?page=4&company[]=Amazon&sortBy=submissions

public class Minimum_Distance_Between_Two_Numbers {
    int minDist(int[] array, int n, int x, int y) {
        int first = -1;
        int second = -1;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x)
                first = i;
            if (array[i] == y)
                second = i;
            if (first != -1 && second != -1) {
                ans = Math.min(ans, Math.abs(first - second));
            }
        }
        return first == -1 || second == -1 ? -1 : ans;
    }
}
