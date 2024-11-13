import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

public class Attendance {
    static void att(int[] arr)
    {
        Arrays.sort(arr);
        System.out.println("Total present : "+ arr.length);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+"  ");
        System.out.println(" ");
        System.out.println("");
        System.out.println("");
        System.out.println("Total Absent : "+(72-arr.length));
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++)
        {
            set.add(arr[i]);
        }
        for(int i=1;i<= 72;i++)
        {
            if(set.contains(i) == false)
                System.out.print(i+"  ");
        }
        System.out.println(" ");
    }
    public static void main(String[] args) {
        String str = "Digital Marketing Management module under Student Leadership Programme  TE COMP A ATTENDANCE";
        System.out.println(str.toUpperCase() +"   "+java.time.LocalDate.now());
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14, 15, 17, 20, 21, 24, 25, 28, 30, 31, 32, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 47, 51, 54, 56, 57, 58, 59,  61 ,62, 65 ,66 ,67 ,69 ,71,63,68,55};
        att(arr);
    }
}
