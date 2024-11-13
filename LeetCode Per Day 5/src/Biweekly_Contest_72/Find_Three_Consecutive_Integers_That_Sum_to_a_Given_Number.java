package Biweekly_Contest_72;

public class Find_Three_Consecutive_Integers_That_Sum_to_a_Given_Number {
    public long[] sumOfThree(long num) {
        long temp = num / 3;

        for (int i = 0; i < 10; i++) {
            long newNumber = temp + i;
            if ((newNumber - 1) + (newNumber) + (newNumber + 1) == num)
                return new long[]{newNumber - 1, newNumber, newNumber + 1};
        }
        for (int i = 0; i > -10; i--) {
            long newNumber = temp + i;
            if ((newNumber - 1) + (newNumber) + (newNumber + 1) == num)
                return new long[]{newNumber - 1, newNumber, newNumber + 1};
        }
        return new long[]{};
    }
}
