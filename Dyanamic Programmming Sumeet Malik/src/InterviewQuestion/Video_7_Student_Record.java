package InterviewQuestion;

import java.util.ArrayList;

public class Video_7_Student_Record {

    static String studentRecord(String[][] vec, int N) {
        String ans = "";
        int res = 0;

        for (String[] record : vec) {
            int v1 = Integer.parseInt(record[1]);
            int v2 = Integer.parseInt(record[2]);
            int v3 = Integer.parseInt(record[3]);
            if ((v1 + v2 + v3) / 3 > res) {
                res = (v1 + v2 + v3) / 3;
                ans = record[0];
            } else if (res == (v1 + v2 + v3) / 3) {
                ans = ans + " " + record[0];
            }
        }
        return ans + " " + res;
    }


}
