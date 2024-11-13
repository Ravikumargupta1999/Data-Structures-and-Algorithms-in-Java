package InterviewQuestion;

import java.util.ArrayList;

public class Positive_and_negative_elements {
    public Positive_and_negative_elements() {
    }

    ArrayList<Long> arranged(long[] arr, int n) {
        ArrayList<Long> al1 = new ArrayList();
        ArrayList<Long> al2 = new ArrayList();

        for(int i = 0; i < n; ++i) {
            if (arr[i] < 0L) {
                al2.add(arr[i]);
            } else {
                al1.add(arr[i]);
            }
        }

        ArrayList<Long> al = new ArrayList();

        for(int i = 0; i < al1.size(); ++i) {
            al.add(al1.get(i));
            al.add(al2.get(i));
        }

        return al;
    }
}
