import java.util.ArrayList;
import java.util.HashMap;

public class Array_24_Common_Element_In_3_Sorted_Array {

    // https://practice.geeksforgeeks.org/problems/common-elements1132/1
    // TC : O( n1 + n2 + n3 )
    // SC : O( n1 + n2 + n3 )
    public static ArrayList<Integer> commonElements1(int[] arr1, int[] arr2, int[] arr3, int n1, int n2, int n3) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();
        HashMap<Integer, Integer> map3 = new HashMap<>();
        for (int i = 0; i < n1; i++) {
            map1.put(arr1[i], map1.getOrDefault(arr1[i], 0) + 1);

        }
        for (int i = 0; i < n2; i++) {
            map2.put(arr2[i], map2.getOrDefault(arr2[i], 0) + 1);

        }
        for (int i = 0; i < n3; i++) {
            map3.put(arr3[i], map3.getOrDefault(arr3[i], 0) + 1);

        }

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            if (map1.containsKey(arr1[i]) && map2.containsKey(arr1[i]) && map3.containsKey(arr1[i])) {
                al.add(arr1[i]);
                map1.remove(arr1[i]);
            }
        }
        if (al.size() == 0)
            al.add(-1);
        return al;
    }

    // TC : O( n1 + n2 + n3 )
    // SC : O( 1 )
    public static ArrayList<Integer> Elements2(int[] arr1, int[] arr2, int[] arr3, int n, int m, int p) {
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList<Integer> al = new ArrayList<>();
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            // Case 1 : All 3 Equal
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                if (al.size() == 0) {
                    al.add(arr1[i]);
                } else if (al.get(al.size() - 1) != arr1[i])
                    al.add(arr1[i]);
                i++;
                j++;
                k++;
                continue;
            }

            // case 2 : A and B Equal
            if (arr1[i] == arr2[j]) {
                if (arr1[i] < arr3[k]) {
                    i++;
                    j++;
                } else {
                    k++;
                }
                continue;
            }


            // Case 3 : A and C equal
            if (arr1[i] == arr3[k]) {
                if (arr1[i] < arr2[j]) {
                    i++;
                    k++;
                } else {
                    j++;
                }
                continue;

            }


            // Case 4 : B and C equal

            if (arr2[j] == arr3[k]) {
                if (arr2[j] < arr1[i]) {
                    j++;
                    k++;
                } else {
                    i++;
                }
                continue;
            }

            // Case 5 : All are different
            if (arr1[i] < arr2[j] && arr1[i] < arr3[k]) {
                i++;
            } else if (arr2[j] < arr1[i] && arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        if (al.size() == 0)
            al.add(-1);
        return al;
    }

}
