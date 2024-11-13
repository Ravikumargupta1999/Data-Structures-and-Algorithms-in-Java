// https://practice.geeksforgeeks.org/problems/convert-from-any-base-to-decimal3736/1/?company[]=Adobe&company[]=Adobe&page=5&query=company[]Adobepage5company[]Adobe

public class Any_Base_to_Decimal {
    static int decimalEquivalent(String N, int b)
    {
        String str = Integer.toString(b);
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
       // System.out.println(2, 1100);
    }
}
