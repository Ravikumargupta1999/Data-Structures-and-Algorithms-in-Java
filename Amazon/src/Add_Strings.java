public class Add_Strings {
    //https://leetcode.com/problems/add-strings/submissions/
    public static String addStrings(String n1, String n2) {
        String res = "";
        int i = n1.length()-1;
        int j = n2.length()-1;
        int carry = 0;
        while (i >=0 || j >=0 )
        {
            int ival = i >=0 ? n1.charAt(i)-'0' : 0;
            int jval = j >=0 ? n2.charAt(j)-'0' : 0;
            System.out.println(ival + "  "+ jval+"  "+carry);
            int sum = ival + jval + carry;
            res = sum % 10 + res;
            carry = sum / 10;
            i--;
            j--;
        }
        if(carry > 0)
            res = carry + res;
        int k =0;
        for(;k<res.length()-1;k++)
        {
            if(res.charAt(k) != '0' )
                break;
        }
        if(k == res.length())
            return "0";
        return res.substring(k);
    }

    //https://practice.geeksforgeeks.org/problems/sum-of-numbers-or-number1219/1
    String findSum(String n1, String n2) {
        String res = "";
        int i = n1.length()-1;
        int j = n2.length()-1;
        int carry = 0;
        while (i >=0 || j >=0 )
        {
            int ival = i >=0 ? n1.charAt(i)-'0' : 0;
            int jval = j >=0 ? n2.charAt(j)-'0' : 0;
            // System.out.println(ival + "  "+ jval+"  "+carry);
            int sum = ival + jval + carry;
            res = sum % 10 + res;
            carry = sum / 10;
            i--;
            j--;
        }
        if(carry > 0)
            res = carry + res;
        int k =0;
        for(;k<=res.length()-1;k++)
        {
            if(res.charAt(k) != '0' )
                break;
        }
        if(k == res.length())
            return "0";
        return res.substring(k);
    }
    public static void main(String[] args) {
        System.out.println(addStrings("0","0"));
    }
}
