
// https://practice.geeksforgeeks.org/problems/rearrange-an-array-with-o1-extra-space3142/1/?category[]=Arrays&category[]=Arrays&page=2&query=category[]Arrayspage2category[]Arrays
// nahi samjha
public class Rearrange_An_Array {
    static void arrange(long arr[], int n) {
        for (int i = 0; i < n; i++)
            arr[i] += (arr[(int)arr[i]] % n) * n;

        for (int i = 0; i < n; i++)
            arr[i] /= n;

        System.out.println("");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "  ");
        System.out.println("");
    }

    public static void main(String[] args) {
        long arr[] = {4, 0, 2, 1, 3};
        arrange(arr, arr.length);
    }
}
