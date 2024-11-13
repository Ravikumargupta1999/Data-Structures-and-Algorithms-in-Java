import java.util.ArrayList;
// https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
// https://www.youtube.com/watch?v=TvvGj1FtHIk
public class Backtracking_282_3_Partitioning_Into_K_Subsets {
    static int count;
    public static void countNoOfWaysIntoKWaysPartitioning(int num, int totalNumber, int k, int noOfSubset, ArrayList<ArrayList<Integer>> ans) {
        if (num > totalNumber) {
            if (noOfSubset == k) {
                count++;
                System.out.print(count + " ->   ");
                for (ArrayList<Integer> set : ans)
                    System.out.print(set + "  ");
                System.out.println("");
            }
            return;
        }
        for (int j = 0; j < ans.size(); j++) {
            if (ans.get(j).size() > 0) {
                ans.get(j).add(num);
                countNoOfWaysIntoKWaysPartitioning(num + 1, totalNumber, k, noOfSubset, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
            } else {
                ans.get(j).add(num);
                countNoOfWaysIntoKWaysPartitioning(num + 1, totalNumber, k, noOfSubset + 1, ans);
                ans.get(j).remove(ans.get(j).size() - 1);
                break;
            }
        }
    }

    public static void main(String[] args) {
        count = 0;
        int n = 3;
        int k = 2;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            ans.add(new ArrayList<>());
        }
        countNoOfWaysIntoKWaysPartitioning(1, 3, 2, 0, ans);
        System.out.println("Total Ways : " + count);
    }
}
