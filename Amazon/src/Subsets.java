import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
//https://practice.geeksforgeeks.org/problems/subsets-1613027340/1/?company[]=Microsoft&company[]=Microsoft&page=20&query=company[]Microsoftpage20company[]Microsoft#

public class Subsets {
    static void generatesSubset(int ind, ArrayList<Integer> arr, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> al1) {
        al1.add(new ArrayList<>(al));
        for (int i = ind; i < arr.size(); i++) {
            al.add(arr.get(i));
            generatesSubset(i + 1, arr, al, al1);
            al.remove(al.size() - 1);
        }

    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr) {
        ArrayList<ArrayList<Integer>> al1 = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        generatesSubset(0, arr, al, al1);
        al1.remove(0);
        Collections.sort(al1, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.size() < o2.size()) {
                    for (int i = 0; i < o1.size(); i++) {
                        if (o1.get(i) != o2.get(i))
                            return o1.get(i) - o2.get(i);
                    }
                }
                if (o1.size() > o2.size()) {
                    for (int i = 0; i < o2.size(); i++) {
                        if (o1.get(i) != o2.get(i))
                            return o1.get(i) - o2.get(i);
                    }
                }
                if (o1.size() == o2.size()) {
                    for (int i = 0; i < o2.size(); i++) {
                        if (o1.get(i) != o2.get(i))
                            return o1.get(i) - o2.get(i);
                    }
                }
                return o1.size() - o2.size();

            }
        });

        return al1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        al.add(6);

        al.add(7);
        al.add(8);

        al.add(9);
        al.add(10);

        al.add(12);
        al.add(14);

        al.add(22);
        al.add(24);

        al.add(32);
        al.add(34);

        al.add(42);
        al.add(44);

        al.add(52);
        al.add(54);

        ArrayList<ArrayList<Integer>> al1 = subsets(al);
        for (int i = 0; i < al1.size(); i++) {
            for (int j = 0; j < al1.get(i).size(); j++)
                System.out.print(al1.get(i).get(j) + "  ");
            System.out.print("\n");
        }
    }
}
