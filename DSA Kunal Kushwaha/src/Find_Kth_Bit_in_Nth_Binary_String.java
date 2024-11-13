import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Find_Kth_Bit_in_Nth_Binary_String {
//    Time Limit Exceeding
//    public char findKthBit(int n, int k) {
//        String str = function(n,1,"0");
//        System.out.println(str);
//        return str.charAt(k-1);
//    }
//    public static String function(int n,int steps,String str)
//    {
//        if(steps == n)
//            return str;
//        String temp = str;
//        str += ("1") + invert(temp);
//        return function(n,steps+1,str);
//    }
//    public static String invert(String str)
//    {
//        String temp = "";
//
//        for(int j = str.length()-1;j>=0;j--)
//        {
//            if(str.charAt(j) == '0' )
//                temp += "1";
//            else
//                temp += "0";
//        }
//        return temp;
//    }

    
   // https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/submissions/
    public char findKthBit(int n, int k) {
        String[] str = new String[n];
        str[0] = "0";
        for(int i=1;i<str.length;i++)
        {
            str[i]  = formString(str[i-1]);
        }
        System.out.println(str[n-1]);
        return str[n-1].charAt(k-1);
    }
    public String formString(String str)
    {
        return str + "1" + reverse(invert(str));
    }
    public String reverse(String str)
    {
        return new StringBuilder(str).reverse().toString();
    }

    public String invert(String str)
    {
        char[] ch = str.toCharArray();
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i] == '0')
                ch[i] = '1';
            else
                ch[i] = '0';
        }
        return new String(ch);
    }
    public static void main(String[] args) {
        Find_Kth_Bit_in_Nth_Binary_String a = new Find_Kth_Bit_in_Nth_Binary_String();
        System.out.println(a.findKthBit(20,11));
    }
}
