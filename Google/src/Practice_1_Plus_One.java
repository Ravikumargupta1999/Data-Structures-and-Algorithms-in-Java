import java.util.ArrayList;

// https://practice.geeksforgeeks.org/problems/plus-one/1
public class Practice_1_Plus_One {
    static ArrayList<Integer> increment(ArrayList<Integer> arr, int n) {
        reverse(arr);
        int remainder = 0;
        for (int i = 0; i < n; i++) {
            int temp = arr.get(i);
            if (i == 0) {
                temp = temp + 1;
                arr.set(i, temp % 10);
                remainder = temp / 10;
            } else {
                temp = temp + remainder;
                arr.set(i, temp % 10);
                remainder = temp / 10;
            }
        }
        if (remainder > 0)
            arr.add(remainder);
        reverse(arr);
        return arr;

    }

    static void reverse(ArrayList<Integer> arr) {
        int i = 0;
        int j = arr.size() - 1;
        while (i <= j) {
            int temp = arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            i++;
            j--;
        }
        return;
    }

    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(9);
        al.add(9);
        al.add(9);
//        al.add(4);
        System.out.println(increment(al, al.size()));
    }
}
