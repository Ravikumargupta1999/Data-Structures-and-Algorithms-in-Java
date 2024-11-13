package Day_9_Recursion;

import java.util.ArrayList;
import java.util.Collections;

public class Subset_Sum {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> list = new ArrayList<>();
        printSubsetSum(arr, 0, 0, list);
        Collections.sort(list);
        return list;
    }

    public void printSubsetSum(ArrayList<Integer> arr, int index, int sum, ArrayList<Integer> res) {
        if (index == arr.size()) {
            res.add(sum);
            return;
        }
        printSubsetSum(arr,index+1,sum,res);
        printSubsetSum(arr,index+1,sum+arr.get(index),res);
    }
}
