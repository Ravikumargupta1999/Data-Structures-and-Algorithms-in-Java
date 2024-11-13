package Biweekly_Contest_63;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Minimum_Number_of_Moves_to_Seat_Everyone {
    // https://leetcode.com/contest/biweekly-contest-63/problems/minimum-number-of-moves-to-seat-everyone/
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int count = 0;
        for (int i=0;i<seats.length;i++){
            count += (Math.abs(seats[i]-students[i]));
        }
        return count;
    }
}
