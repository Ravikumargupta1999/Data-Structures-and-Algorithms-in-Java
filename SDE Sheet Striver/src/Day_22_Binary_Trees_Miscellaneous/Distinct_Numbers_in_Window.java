package Day_22_Binary_Trees_Miscellaneous;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Distinct_Numbers_in_Window {
    // https://www.interviewbit.com/problems/distinct-numbers-in-window/
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < A.size(); i++) {
            if (i < B - 1)
                map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
            else {
                map.put(A.get(i), map.getOrDefault(A.get(i), 0) + 1);
                list.add(map.size());
                if (map.get(A.get(j)) == 1) {
                    map.remove(A.get(j));
                } else {
                    map.put(A.get(j), map.get(A.get(j)) - 1);
                }
                j++;
            }
        }
        return list;
    }
}
