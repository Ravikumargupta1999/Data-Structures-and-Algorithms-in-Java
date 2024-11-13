public class Doubling_the_value {
    long solve(int n, long arr[], long b) {
        // Complete this function

        for (int i = 0; i < n; i++) {
            if (arr[i] == b) {
                b += arr[i];
                arr[i] = 2 * arr[i];
                // b += arr[i];
            }
        }
        return b;
    }
}
//https://practice.geeksforgeeks.org/problems/doubling-the-value4859/1/?company[]=Flipkart&company[]=Flipkart&page=1&query=company[]Flipkartpage1company[]Flipkart
