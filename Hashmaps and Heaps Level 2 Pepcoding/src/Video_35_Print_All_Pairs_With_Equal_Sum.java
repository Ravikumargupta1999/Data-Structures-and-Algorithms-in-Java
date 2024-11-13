import java.util.ArrayList;
import java.util.HashMap;
// https://www.geeksforgeeks.org/print-all-pairs-in-an-unsorted-array-with-equal-sum/
public class Video_35_Print_All_Pairs_With_Equal_Sum {
    public static void main(String[] args) {
        float a = 22.0f;
        float b = 7.0f;
        float result = a / b;
        System.out.println(result);
        int[] arr = { 6, 4, 12, 10, 22, 54, 32, 42, 21, 11};
        printPairs(arr);
    }
    public static void printPairs(int[] arr){
        HashMap<Integer, ArrayList<Integer[]>> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            for (int j=i+1;j<arr.length;j++){
                int sum = arr[i] + arr[j];
                if(map.containsKey(sum)){
                    map.get(sum).add(new Integer[]{arr[i],arr[j]});
                }
                else {
                    ArrayList<Integer[]> al = new ArrayList<>();
                    al.add(new Integer[]{arr[i],arr[j]});
                    map.put(sum,al);
                }
            }
        }
        for (int temp : map.keySet()){
            System.out.print(" Sum : "+temp+"   Pairs : ");
            for (Integer[] al : map.get(temp)){
                System.out.print("("+al[0]+"," +al[1]+") ");
            }
            System.out.println();
        }

    }
}
