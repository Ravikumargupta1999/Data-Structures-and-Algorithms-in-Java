import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/submissions/

public class Find_All_Numbers_Disappeared_in_an_Array {
    public static List<Integer> findDisappearedNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == arr.length+1)
                continue;
            while (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                if(arr[i] == arr.length+1 || arr[arr[i]-1] ==arr[i])
                    break;
            }
        }
        List<Integer> al = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
            if(i + 1 != arr[i])
                al.add(i+1);

//        boolean found = false;
//        for(int i=0;i<arr.length;i++)
//        {
//
//            if(arr[i] == arr.length) {
//               found = true;
//               break;
//            }
//        }
//        if(found)
//            return al;
//        System.out.println("Hello");
//        al.add(arr.length);
        return al;

    }

    public static void main(String[] args) {
        System.out.println(findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1} ));
    }
}
