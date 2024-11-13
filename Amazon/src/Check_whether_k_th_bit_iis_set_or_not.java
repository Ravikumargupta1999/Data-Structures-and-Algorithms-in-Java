//https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1/?company[]=Microsoft&company[]=Microsoft&page=2&query=company[]Microsoftpage2company[]Microsoft#

public class Check_whether_k_th_bit_iis_set_or_not {
    static boolean checkKthBit(int n, int k)
    {
        String str = Integer.toBinaryString(n);
        if(k< 0 || k >= str.length())
            return false;
        System.out.println(str);
        System.out.println(str.length()-1-k);
        if(str.charAt(str.length()-1-k) == '1')
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkKthBit(500,5));
    }
}
