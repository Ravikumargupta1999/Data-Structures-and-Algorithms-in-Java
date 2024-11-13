import java.util.ArrayList;
import java.util.Collections;
//https://practice.geeksforgeeks.org/problems/construct-list-using-given-q-xor-queries/1/?category[]=Arrays&category[]=Arrays&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=3&query=category[]Arrayscompany[]Amazondifficulty[]1page3company[]Amazoncategory[]Arrays#

public class Construct_list_using_given_q_XOR_queries {
    static ArrayList<Integer> constructList(ArrayList<ArrayList<Integer>> queries, int N) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(0);
        for (int i = 0; i < queries.size(); i++) {
            if (queries.get(i).get(0) == 0)
                al.add(queries.get(i).get(1));
            else if (queries.get(i).get(0) == 1) {
                for (int j = 0; j < al.size(); j++) {
                    int val = al.get(j);
                    al.set(j, val ^ queries.get(i).get(1));
                }
            }
        }
        Collections.sort(al);
        return al;
    }
    static ArrayList<Integer> constructList1(ArrayList<ArrayList<Integer>> queries, int N)
    {
        int xor = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = queries.size()- 1; i >= 0; i--) {

            if (queries.get(i).get(0) == 0)
                ans.add(queries.get(i).get(1)^ xor);

            else
                xor ^= queries.get(i).get(1);
//            System.out.println(i+"  "+ans);
        }
        ans.add(xor);
        Collections.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] q = {{0, 2}, {1, 3}, {0, 5}};
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for (int i = 0; i < q.length; i++)
            al.add(new ArrayList<>());
        for (int i = 0; i < q.length; i++) {
            al.get(i).add(q[i][0]);
            al.get(i).add(q[i][1]);
        }
//        System.out.println(al);
        System.out.println(constructList1(al, al.size()));

    }
}
