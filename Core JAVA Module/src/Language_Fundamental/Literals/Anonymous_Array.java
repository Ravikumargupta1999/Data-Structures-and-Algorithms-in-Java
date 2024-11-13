package Language_Fundamental.Literals;

import java.util.Arrays;

public class Anonymous_Array {
    public static void main(String[] args) {
        main(new int[]{56,78,99});
//        main(new int[3]{56,78,99});
    }

    public static void main(int[] arr)
    {
        System.out.println(Arrays.toString(arr));
    }
}
