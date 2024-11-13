public class ithBit {
    public static int kthBit(int n, int i) {
        int val = 1 << (i - 1);
        System.out.println(Integer.toBinaryString(val));
        System.out.println(Integer.toBinaryString(n));
        return (n & (1 << (i - 1)) ) > 0 ? 1 : 0 ;
    }

//    public static char val(String fun) {
//        int count = 0;
//        for (int i = 100; i <= 999; i++)
//            if (i % 6 == 0)
//                count++;
//        System.out.println(count);
//
//        String result = "";
//        String reverse = reverse(fun);
//        for (int i = 1; i < 100; i++) {
//            result += fun;
//            result += reverse;
//        }
//        return result.charAt(812 - 1);
//    }
//
//    public static String reverse(String a) {
//        StringBuffer f = new StringBuffer();
//        f = f.append(a);
//        return f.reverse().toString();
//    }

    public static void main(String[] args) {
//        System.out.println(val("ARRANGEMENT"));
        System.out.println(kthBit(-13, 2));
    }
}
