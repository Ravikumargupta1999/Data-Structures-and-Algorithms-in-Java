import java.util.*;
//https://www.youtube.com/watch?v=RIn3gOkbhQE
//https://practice.geeksforgeeks.org/problems/subsets-1613027340/1/?category[]=Recursion&category[]=Recursion&difficulty[]=1&page=2&query=category[]Recursiondifficulty[]1page2category[]Recursion#
public class Subset_Of_An_Array_Recursively_Gfg {
    static void generatesSubset(int ind, ArrayList<Integer> arr, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> al1)
    {
        al1.add(new ArrayList<>(al));
        for(int i=ind;i<arr.size();i++) {
            if(i != ind && arr.get(i) == arr.get(i-1))
                continue;
            // generatesSubset(i + 1, arr, al, al1);
            al.add(arr.get(i));
            generatesSubset(i + 1, arr, al, al1);
            al.remove(al.size() - 1);
        }

    }

    public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> arr)
    {
        Collections.sort(arr);
        ArrayList<ArrayList<Integer>> al1 = new ArrayList<>();
        ArrayList<Integer> al = new ArrayList<>();
        generatesSubset(0,arr,al,al1);
        /*Collections.sort(al1, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.size()-o2.size();
            }
        });*/
        return al1;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        System.out.println(subsets(al));
    }
}
