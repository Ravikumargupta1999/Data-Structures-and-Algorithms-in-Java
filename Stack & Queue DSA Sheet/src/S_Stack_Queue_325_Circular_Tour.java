public class S_Stack_Queue_325_Circular_Tour {
    // https://practice.geeksforgeeks.org/problems/circular-tour/1#
    // Brute Force
    static int Tour(int[] petrol, int[] distance) {
        int n = petrol.length;
        for (int i = 0; i < n; i++) {
            int current = petrol[i] - distance[i];
            int j = i == n - 1 ? 0 : i + 1;
            while (j != i && current >= 0) {
                current += (petrol[j] - distance[j]);
                if (current < 0)
                    break;
                j = j == n - 1 ? 0 : j + 1;
            }
            if (j == i)
                return i;
        }
        return -1;

    }

    //    https://www.youtube.com/watch?v=_gJ3to4RyeQ
    static int tour(int[] petrol, int[] distance) {
        int start = 0;
        int deficient = 0;
        int balance = 0;
        for (int i = 0; i < petrol.length; i++) {
            balance += (petrol[i] - distance[i]);
            if (balance < 0) {
                start = i + 1;
                deficient += balance;
                balance = 0;
            }
        }
        return balance + deficient >= 0 ? start : -1;
    }

}
