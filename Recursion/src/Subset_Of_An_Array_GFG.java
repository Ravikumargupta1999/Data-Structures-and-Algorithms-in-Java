import java.util.ArrayList;
// https://www.youtube.com/watch?v=RIn3gOkbhQE
// https://practice.geeksforgeeks.org/problems/subsets-1613027340/1/?category[]=Recursion&category[]=Recursion&difficulty[]=1&page=2&query=category[]Recursiondifficulty[]1page2category[]Recursion#

public class Subset_Of_An_Array_GFG {
    static ArrayList<ArrayList<Integer>> printPowerSet(int []set, int set_size)
    {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        long pow_set_size = (long)Math.pow(2, set_size);
        int counter, j;

        for(counter = 0; counter < pow_set_size; counter++)
        {
            ArrayList<Integer> al = new ArrayList<>();
            for(j = 0; j < set_size; j++)
            {
                if((counter & (1 << j)) > 0) {
                    al.add(set[j]);
                    System.out.print(set[j]+" ");
                }
            }
            result.add(al);

            System.out.println();
        }
        System.out.println(result);
        System.out.println(result.size());
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {5, 6, 6, 10, 3, 4 ,6, 6, 4};
        System.out.println(printPowerSet(arr,arr.length));
    }
}
