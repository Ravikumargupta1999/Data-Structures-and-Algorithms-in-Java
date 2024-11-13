package InterviewQuestion;

import java.util.ArrayList;

public class Video_50_Generate_All_SubArray_Using_Recursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        generateAllSubArrays(0, arr, temp, list, true);
        System.out.println(list);
    }

    public static void generateAllSubArrays(int index, int[] arr, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list, boolean flag) {
        if (index == arr.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        if (temp.size() != 0)
            list.add(new ArrayList<>(temp));
        if (flag) {
            for (int i = index; i < arr.length; i++) {
                temp.add(arr[i]);
                generateAllSubArrays(i + 1, arr, temp, list, false);
                temp.remove(temp.size()-1);
            }

        } else {
            temp.add(arr[index]);
            generateAllSubArrays(index + 1, arr, temp, list,false);
            temp.remove(temp.size() - 1);
        }

    }
}
