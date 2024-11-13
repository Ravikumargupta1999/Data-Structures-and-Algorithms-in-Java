import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Multiply_Two_String {

    // https://leetcode.com/problems/multiply-strings/submissions/
    public static String multiplyStrings(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 == 1 || l2 == 1)
        {
            if(s1.charAt(0) =='0')
                return "0";
            else if(s2.charAt(0) == '0')
                return "0";
        }
        int[] res = new int[l1 + l2];
        int i = s1.length() - 1;
        int pf = 0;
        while (i >= 0) {
            int ival = s1.charAt(i) - '0';
            i--;
            int k = res.length - 1 - pf;
            int j = l2 - 1;
            int carry = 0;
            while (j >= 0 || carry != 0)
            {
                int jval = j >= 0 ? s2.charAt(j)-'0' :0;
                j--;
                int prod = ival*jval + carry + res[k];
                res[k] = prod%10;
                carry = prod/10;
                k--;
            }
            pf++;
        }
        String st = "";
        boolean flag = false;
        for(int val : res)
        {
            if(val == 0 && flag == false)
                continue;
            else
            {
                st += val;
                flag = true;
            }
        }
        return st;
    }
    //https://practice.geeksforgeeks.org/problems/multiply-two-strings/1
    public static String multiplyStrings1(String s1, String s2) {

        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 == 1 || l2 == 1)
        {
            if(s1.charAt(0) =='0')
                return "0";
            else if(s2.charAt(0) == '0')
                return "0";
        }
        boolean negetive = false;
        if(s1.charAt(0) == '-' && s2.charAt(0) =='-')
        {
            negetive = false;
            s1 = s1.substring(1);
            s2 = s2.substring(1);
            l1 = l1 -1;
            l2 = l2-1;
        }
        else if(s1.charAt(0) == '-')
        {
            negetive = true;
            s1 = s1.substring(1);
            l1 = l1 -1;
        }
        else if(s2.charAt(0) == '-')
        {
            negetive = true;
            s2 = s2.substring(1);
            l2 = l2 -1;
        }
        System.out.println(s1+"  "+l1);
        System.out.println(s2+"  "+l2);

        int[] res = new int[l1 + l2];
        int i = s1.length() - 1;
        int pf = 0;
        while (i >= 0) {
            int ival = s1.charAt(i) - '0';
            i--;
            int k = res.length - 1 - pf;
            int j = l2 - 1;
            int carry = 0;
            while (j >= 0 || carry != 0)
            {
                int jval = j >= 0 ? s2.charAt(j)-'0' :0;
                j--;
                int prod = ival*jval + carry + res[k];
                res[k] = prod%10;
                carry = prod/10;
                k--;
            }
            pf++;
        }
        String st = "";
        if(negetive)
            st += '-';
        boolean flag = false;
        for(int val : res)
        {
            if(val == 0 && flag == false)
                continue;
            else
            {
                st += val;
                flag = true;
            }
        }
        System.out.println("Hello");
        return st;
    }
    public static void main(String[] args) {
        System.out.println(multiplyStrings1("-22", "-34"));
        System.out.println(45*445);
    }
}
