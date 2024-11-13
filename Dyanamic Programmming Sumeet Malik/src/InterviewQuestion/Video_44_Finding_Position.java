package InterviewQuestion;

import java.util.ArrayList;

public class Video_44_Finding_Position {
    static long nthPosition(long n) {
        ArrayList<Long> list = new ArrayList<>();
        for (long l = 1; l <= n; l++) {
            list.add(l);
        }

        while (list.size() > 1) {
//            System.out.println(list);
            ArrayList<Long> temp = new ArrayList<>();
            for (long i = 1; i < list.size(); i+=2) {
                temp.add(list.get((int) i));
            }
            list = new ArrayList<>(temp);
//            System.out.println(list+"\n\n");
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(nthPosition(5));
    }
}
