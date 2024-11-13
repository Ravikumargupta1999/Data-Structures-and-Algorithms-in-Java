// https://practice.geeksforgeeks.org/problems/reverse-bits3556/1
public class Reverse_Bits {
    long reverse(long n)
    {
        String str =  InttoBinary(n);
        // System.out.println(str);
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        sb.reverse();
        // System.out.println(sb);
        str = sb.toString();
        if(n % 2 == 1)
            return StringToBinary(str)+1;
        return StringToBinary(str);
    }
    String InttoBinary(long n)
    {
        long val = n;
        String str = "";
        while (n >= 1) {
            if (n % 2 == 0) {
                str = 0 + str;
            } else {
                str = 1 + str;
            }
            n = n / 2;
        }
        for(int i=str.length();i<32;i++)
        {
            str = 0 + str;
        }
        return str;
    }
    long StringToBinary(String str)
    {
        long val = 0;
        int ind = 0;
        for(int i=str.length()-1;i>=0;i--)
        {
            if(str.charAt(i) == '1')
            {
                val = val + (int)Math.pow(2,ind);
                ind++;
            }
            else
            {
                ind++;
            }
        }
        return val;
    }
    public static void main(String[] args) {
        Reverse_Bits a = new Reverse_Bits();
        //int
        System.out.println(a.reverse(3));
    }
}
