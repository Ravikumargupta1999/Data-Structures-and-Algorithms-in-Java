//https://www.youtube.com/watch?v=jKyuWD8XKjw&list=PL-Jc9J83PIiHOV7lm2uSw4ZiVsIRsGS6r&index=28

public class Difference_of_two_arrays {
    public static void main(String[] args) {
        int[] arr1 = {9, 9, 9, 9, 9};
        int[] arr2 = {3, 3, 3, 3, 3, 3};
        printDifference(arr1, arr2);
    }

    static void printDifference(int[] arr1, int[] arr2) {
        int[] diff = new int[arr2.length];
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = diff.length - 1;
        int c = 0;
        while (k >= 0) {
            int alv = i >= 0 ? arr1[i] : 0;
            int d = 0;
            if (arr2[j] + c >= alv) {
                d = arr2[j] + c - alv;
                c = 0;
            } else {
                d = arr2[j] + c + 10 - alv;
                c = -1;
            }
            diff[k] = d;
            k--;
            i--;
            j--;
        }
        i = 0;
        while (i < diff.length)
            if (diff[i] == 0)
                i++;
            else
                break;
        while (i < diff.length)
            System.out.print(diff[i++]);
        System.out.println("");

    }

}
