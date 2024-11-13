import java.util.Arrays;

// https://practice.geeksforgeeks.org/problems/binary-number-to-decimal-number3525/1/?company[]=Adobe&company[]=Adobe&page=1&query=company[]Adobepage1company[]Adobe
public class Binary_To_Decimal {
    public static int binary_to_decimal(String str)
    {
        int value = 0;
        int n = str.length()-1;
        int i =0;
        while (n >= 0)
        {
            if (str.charAt(n) =='0')
            {
                value = value ;
                i++;
            }
            else
            {
                value = value + (int)(Math.pow(2,i));
                i++;
            }
            n--;
        }
        return value;
    }
    public static void main(String[] args) {
//        int[] arr = {2344,56};
//        System.out.println("This is Array "+ Arrays.toString(arr));
//        System.out.println(binary_to_decimal("1000100010001000"));

        int i = 1;
        while(i < 10){

            if ( i % 2 == 0){
                i = i + 1;
                continue;
            }
            System.out.println(i);
            i = i + 1;
        }

    }
}
