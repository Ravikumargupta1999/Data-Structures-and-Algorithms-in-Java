package InterviewQuestion;

import java.util.ArrayList;
import java.util.Collections;

public class Video_33_Generate_Grey_Code {
    public ArrayList<String> graycode(int n)
    {
        if (n == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add("0");
            list.add("1");
            return list;
        }

        ArrayList<String> prev = graycode(n - 1);

        ArrayList<String> curr = new ArrayList<>();


        for (String str : prev) {
            curr.add("0" + str);

        }
        for (int i = prev.size() - 1; i >= 0; i--) {
            String str = prev.get(i);
            curr.add("1" + str);

        }
        return curr;
    }


}
