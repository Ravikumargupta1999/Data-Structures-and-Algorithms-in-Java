import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Number_of_subsets_with_product_less_than_k {
    static int numOfSubsets(int[] arr, int n, int k) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        findAllSubset(arr,0,al,new ArrayList<>());
        int count = 0;
        for (int i=0;i<al.size();i++)
        {
            int product = 1;
            for(int j=0;j<al.get(i).size();j++)
            {
                product = product*al.get(i).get(j);
            }

            if(product<=k && al.get(i).size() != 0) {
                System.out.println(al.get(i));
                count++;
            }
        }
        return count;

    }
    public static void findAllSubset(int[] arr,int index,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> al)
    {
        if(index == arr.length)
        {
            res.add(al);
            return;
        }
        System.out.println(al+"   "+new ArrayList<>(al));
        findAllSubset(arr,index+1,res,new ArrayList<>(al));
        al.add(arr[index]);
        findAllSubset(arr,index+1,res,new ArrayList<>(al));
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3};

        System.out.println(numOfSubsets(arr,arr.length,12));
    }
}
