package InterviewQuestion;

import java.util.ArrayList;
import java.util.HashMap;

public class Video_57_Count_Distinct_Elements_In_Every_Window {
    // https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k - 1; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }
        int j = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = k - 1; i < n; i++) {
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            res.add(map.size());

            if (map.get(A[j]) < 2)
                map.remove(A[j]);
            else
                map.put(A[j], map.get(A[j]) - 1);
            j++;
        }
        return res;
    }
}
