package Google_Tagged_Leetcode_Question;

import java.util.ArrayList;
import java.util.List;

public class Leet_Code_401_Binary__Watch {
    public List<String> readBinaryWatch(int turnedOn) {
//        6
//        0 6
//        1 5
//        2 4
//        3 3
//        4 2
//        5 1
//        6 0

        int H = 0;
        while (H <= turnedOn) {
            int M = turnedOn - H;
            if (H > 4 && M > 11) {
                H++;
                continue;
            }
            for (int i = 0; i < (1 << H); i++){

            }
        }
        return new ArrayList<>();
    }
}
