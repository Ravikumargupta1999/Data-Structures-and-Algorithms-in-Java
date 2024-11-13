import java.util.ArrayList;
import java.util.HashSet;

//https://practice.geeksforgeeks.org/problems/completing-tasks0454/1
public class Video_41_Task_Completion {
    class Tasks {
        ArrayList<Integer> tanya, manya;

        Tasks() {
            tanya = new ArrayList<>();
            manya = new ArrayList<>();
        }
    }

    Tasks findTasks(int[] arr, int m, int n) {
        Tasks a = new Tasks();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++)
            set.add(arr[i]);
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                if (flag) {
                    a.tanya.add(i);
                    flag = !flag;
                } else {
                    a.manya.add(i);
                    flag = !flag;
                }
            }
        }
        return a;
    }
}
