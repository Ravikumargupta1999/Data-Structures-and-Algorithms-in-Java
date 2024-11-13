public class String_Comparison {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println((s1 == s2) + "    " + (s1 == s3));
        System.out.println(s1.equals(s2) + "    " + s1.equals(s3));

    }
}
