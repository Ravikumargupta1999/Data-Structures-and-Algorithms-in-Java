//https://practice.geeksforgeeks.org/problems/game-of-xor1541/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0page5company[]Amazon

public class Game_Of_XOR {
    static int gameOfXor(int N, int[] arr) {
        int res = 0;

        // select the starting element
        for (int i = 0; i < N; i++)

            // select the ending element
            for (int j = i; j < N; j++)

                // Do XOR of elements
                // in current sub array
                for (int k = i; k <= j; k++)
                    res = res ^ arr[k];
        return res;
    }

    // Better Approach
    static int gameOfXor1(int n, int[] arr) {

        int res = 0;

        for (int i = 0; i < n; i++) {
            int val = (i + 1) * (n - i);
            if (val % 2 != 0)
                res ^= arr[i];
        }
        return res;
    }
}
