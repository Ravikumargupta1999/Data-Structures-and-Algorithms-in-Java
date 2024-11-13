public class Add_Binary_Strings {
    static String addBinary(String a, String b) {
        int s = 0;
        StringBuilder result = new StringBuilder();

        // Traverse both strings starting
        // from last characters
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || s == 1)
        {

            // Comput sum of last
            // digits and carry
            s += ((i >= 0)? a.charAt(i) - '0': 0);
            s += ((j >= 0)? b.charAt(j) - '0': 0);

            // If current digit sum is
            // 1 or 3, add 1 to result
 //           result = (char)(s % 2 + '0') + result;
//
            // Compute carry
            s /= 2;

            // Move to next digits
            i--; j--;
        }
        System.out.println(result);
        int k =0;
        for (;k<= result.length()-2;k++)
        {
            if(result.charAt(k) == '1')
                break;
        }

        if(result.length() == 0)
            return "0";
        if(k == 0 )
            return "";
     //       return result;
        return result.substring(k);
    }
    // https://leetcode.com/problems/add-binary/submissions/
    public String addBinary1(String s1, String s2) {
        StringBuilder res = new StringBuilder();
        int i = s1.length()-1;
        int j = s2.length()-1;
        int carry = 0;
        while (i >= 0 || j >=0 )
        {
            int ival = i >=0 ? s1.charAt(i)-'0' : 0;
            int jval = j >=0 ? s2.charAt(j)-'0' : 0;
            if (ival + jval + carry == 3) {
                res.insert(0,"1");
                carry = 1;
            }
            else if(ival + jval + carry == 2)
            {
                res.insert(0,"0");
                carry = 1;
            }
            else if(ival + jval + carry == 1)
            {
                res.insert(0,"1");
                carry = 0;
            }
            else if(ival + jval + carry == 0)
            {
                res.insert(0,"0");
                carry = 0;
            }
            i--;
            j--;
        }
        if(carry == 1)
            res.insert(0,'1');
        //  int k =0;
        // while (k <= res.length()-1)
        // {
        //     if(res.charAt(k) == '1')
        //         break;
        //     k++;
        // }
        // if(k == 0 && k <= res.length()-1)
        //     return res.toString();
        if(res.length() == 0)
            return "0";
        return res.toString();
    }

    public static void main(String[] args) {
     System.out.println(addBinary("00001","00"));
    }
}
