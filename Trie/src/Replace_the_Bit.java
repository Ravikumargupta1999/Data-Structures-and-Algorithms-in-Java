//https://practice.geeksforgeeks.org/problems/replace-the-bit3212/0/?category[]=Strings&category[]=Strings&difficulty[]=-2&difficulty[]=-1&page=3&query=category[]Stringsdifficulty[]-2difficulty[]-1page3category[]Strings#

public class Replace_the_Bit {
    static int replaceBit(int n, int k) {
        k = k - 1;
        String str = Integer.toBinaryString(n);
        StringBuffer sb = new StringBuffer();
        sb = sb.append(str);
        if(k > sb.length()-1 || k < 0)
            return n;
        if(sb.charAt(k) == '1')
        {
            sb.replace(k,k+1,"0");
        }
        return Integer.parseInt(sb.toString(),2);
    }

    public static void main(String[] args) {
        System.out.println(replaceBit(932, 5));
    }
}
