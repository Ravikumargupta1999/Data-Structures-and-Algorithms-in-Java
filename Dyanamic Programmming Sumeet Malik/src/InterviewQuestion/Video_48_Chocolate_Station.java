package InterviewQuestion;

public class Video_48_Chocolate_Station {
    long getChocolateCost(long arr[], int chocolateMRP) {
        long bought = arr[0];
        long balance = 0;

        for (long i = 0; i < arr.length - 1; i++) {
            long curr = arr[(int) i] - arr[(int) (i + 1)];

            if (curr >= 0)
                balance += curr;
            else {
                curr = -curr;
                if (balance >= curr)
                    balance -= curr;
                else {
                    curr -= balance;
                    balance = 0;
                    bought += curr;
                }
            }
        }
        return bought * chocolateMRP;
    }
}
