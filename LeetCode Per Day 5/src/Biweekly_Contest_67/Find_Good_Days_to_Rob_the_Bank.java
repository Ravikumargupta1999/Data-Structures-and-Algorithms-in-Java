package Biweekly_Contest_67;

import java.util.ArrayList;
import java.util.List;

public class Find_Good_Days_to_Rob_the_Bank {
    public static void main(String[] args) {
        int[] security = {5,3,3,3,5,6,2,3,42,54,6,7,8,99,11,55,2,2,457,89,223,467,7};
        int time = 2;
        System.out.println(goodDaysToRobBank(security,time));
    }
    public static List<Integer> goodDaysToRobBank(int[] security, int time) {
        if (time == 0) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < security.length; i++)
                list.add(i);
            return list;
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < security.length; i++) {
            if (i - time < 0 || i + time > security.length - 1)
                continue;

            int temp = time;
            int j = i - 1;
            boolean flag = false;
            while (temp-- > 0) {
                if (security[j] < security[j + 1]) {
                    flag = true;
                    break;
                }
                j--;
            }
            if (flag)
                continue;

            j = i + 1;
            temp = time;

            flag = false;
            while (temp-- > 0) {
                if (security[j] < security[j - 1]) {
                    flag = true;
                    break;
                }
                j++;
            }

            if (flag)
                continue;

            list.add(i);

        }
        return list;
    }
}
