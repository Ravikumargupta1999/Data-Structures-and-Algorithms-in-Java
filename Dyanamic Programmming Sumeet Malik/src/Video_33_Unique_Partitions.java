import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Video_33_Unique_Partitions {
    public static void main(String[] args) {
        System.out.println(new Video_33_Unique_Partitions().UniquePartitions(6));
    }

    public ArrayList<ArrayList<Integer>> UniquePartitions(int n) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        ArrayList<Integer> temp = new ArrayList<>();
        getUniquePartition(n, n, temp, list);
        Collections.sort(list, (a, b) -> {

            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                if (a.get(i) != b.get(i))
                    return b.get(i) - a.get(i);
            }

            return a.get(0) - b.get(0);
        });
        return list;
    }

    public void getUniquePartition(int n, int i, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list) {

        if (n == 0) {
            ArrayList<Integer> newList = new ArrayList<>(temp);
            Collections.sort(newList, (a, b) -> {
                return b - a;
            });
            list.add(newList);
            return;
        }

        if (i <= n) {
            for (; i > 0; i--) {
                temp.add(i);
                getUniquePartition(n - i, i, temp, list);
                temp.remove(temp.size() - 1);
            }
        } else {
            for (i = n; i > 0; i--) {
                temp.add(i);
                getUniquePartition(n - i, i, temp, list);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
