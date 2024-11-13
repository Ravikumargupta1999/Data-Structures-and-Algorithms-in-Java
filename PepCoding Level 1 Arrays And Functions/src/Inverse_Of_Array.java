public class Inverse_Of_Array {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 4, 0, 2, 1};
        System.out.print("Index  :  ");
        for(int i=0;i<arr.length;i++)
            System.out.print(i+"   ");
        System.out.println("");
        System.out.print("Values :  ");
        for (int val : arr)
            System.out.print(val + "   ");
        System.out.println("");
        arr = inverse(arr);
        System.out.print("Values :  ");
        for (int val : arr)
            System.out.print(val + "   ");
        System.out.println("");
    }

    static int[] inverse(int[] arr) {
        int[] inv = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int v = arr[i];
            inv[v] = i;
        }
        return inv;

    }
}
