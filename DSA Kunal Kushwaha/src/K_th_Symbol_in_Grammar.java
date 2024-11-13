public class K_th_Symbol_in_Grammar {
    //    public int kthGrammar(int n, int k) {
//        String[] str = new String[n];
//        str[0] = "0";
//        for(int i=1;i<n;i++)
//        {
//            str[i] = formString(str[i-1]);
//        }
//        System.out.println(str[n-1]);
//        int val = (str[n-1].charAt(k-1));
//        return val== 49 ? 1 : 0;
//    }
//    public String formString(String str)
//    {
//        StringBuilder builder = new StringBuilder();
//        for(int i=0;i<str.length();i++)
//        {
//            if(str.charAt(i) == '0')
//                builder.append("01");
//            else
//                builder.append("10");
//        }
//        return builder.toString();
//    }
    public int kthGrammar(int n, int k) {
        if( n== 1 && k == 1)
            return 0;
        int mid = (int)Math.pow(2,n-1)/2;
        if(k <= mid)
            return kthGrammar(n-1,k);
        else
            return kthGrammar(n-1,k-mid)^1;
    }


    public static void main(String[] args) {
        K_th_Symbol_in_Grammar a = new K_th_Symbol_in_Grammar();
        System.out.println(a.kthGrammar(3, 3));
    }
}
