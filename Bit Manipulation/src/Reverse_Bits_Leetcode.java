public class Reverse_Bits_Leetcode {
    int reverse(int n)
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
    String InttoBinary(int n)
    {

        int val = n;
        String str = "";
        if(n < 0)
        {
            str = "1";
            n = -n;
        }
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
    int StringToBinary(String str)
    {
        int val = 0;
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
        Reverse_Bits_Leetcode a = new Reverse_Bits_Leetcode();
        System.out.println(a.reverse(-3));

    }
}
