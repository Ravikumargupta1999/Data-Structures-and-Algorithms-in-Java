public class Video_39_Chocolate_Station {
    // https://practice.geeksforgeeks.org/problems/chocolate-station2951/1
    static long getChocolateCost(long[] arr, int chocolateMRP) {
        long bought = 0;
        bought = arr[0];
        long balance = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                balance += arr[i] - arr[i + 1];
            } else {

                long chocolate = (arr[i + 1] - arr[i]);
                if (balance == chocolate) {
                    balance = 0;
                } else if (balance > chocolate) {
                    balance = balance - chocolate;
                } else {
                    chocolate = chocolate - balance;
                    bought += chocolate;
                    balance = 0;
                }

            }

        }
        return bought > 0 ? bought * chocolateMRP : 0;
    }

    public static void main(String[] args) {
        int price = 5;
        long[] arr = {10, 6, 11, 4, 7, 1};
        System.out.println(getChocolateCost(arr, price));
    }
}
