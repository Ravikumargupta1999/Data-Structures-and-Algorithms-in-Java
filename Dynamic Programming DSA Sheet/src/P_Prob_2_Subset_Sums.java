import java.util.*;

public class P_Prob_2_Subset_Sums {
    // https://practice.geeksforgeeks.org/problems/subset-sums2234/1
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        findSubsetSum(arr, 0, N, 0, arrayList);
        Collections.sort(arrayList);
        return arrayList;
    }

    void findSubsetSum(ArrayList<Integer> arr, int currIndex, int size, int currSum, ArrayList<Integer> result) {
        if (currIndex == size) {
            result.add(currSum);
            return;
        }
        findSubsetSum(arr, currIndex + 1, size, currSum + arr.get(currIndex), result);
        findSubsetSum(arr, currIndex + 1, size, currSum, result);
    }


}
