import java.lang.reflect.Array;
import java.util.Arrays;

public class Single_Number_II {
    public static int singleNumber(int[] arr) {
        int[] str = new int[32];
        for (int num : arr) {
            countNum(str, num);
        }
        for (int i = 0; i < str.length; i++) {
            str[i] = str[i] % 3;
        }
        System.out.println(Arrays.toString(str));
        String temp = "";
        boolean found = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 0 && found == true) {
                temp += str[i];
            }
            else if(str[i] == 1)
            {
//                System.out.println("hhee");
                found = true;
                temp += ""+ str[i];
            }
            System.out.println(temp+"   "+str[i]);
        }
        System.out.println(temp+"  "+temp.length());
        if( temp == "")
            return 0;
        return Integer.parseInt(temp,2);
    }

    public static void countNum(int[] str, int num) {
        String temp = Integer.toBinaryString(num);
        int j = str.length - 1;
        int i = temp.length() - 1;
        while (i >= 0) {
            str[j--] += temp.charAt(i) == '1' ? 1 : 0;
            i--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2,-2,1,1,4,1,4,4,-4,-2};
        System.out.println(singleNumber(arr));
    }
}
