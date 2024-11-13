public class SB {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);
        }
        System.out.println(builder);
        builder.delete(0,0);
        System.out.println(builder);
        System.out.println(builder.delete(0,1));
        System.out.println(builder);
        builder.deleteCharAt(7);
        System.out.println(builder);
        builder.insert(5,6);
        System.out.println(builder);
        builder.insert(5,"5");
        System.out.println(builder);
        builder.reverse();
        System.out.println(builder);
    }
}
