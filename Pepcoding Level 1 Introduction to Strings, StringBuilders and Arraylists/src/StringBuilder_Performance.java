public class StringBuilder_Performance {
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < 10000; i++) {
            sb.append(i);
        }
//        System.out.println(sb);
        long end1 = System.currentTimeMillis();
        System.out.println(end1 - start1);

        System.out.println("\n\n");
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 10000; i++) {
            s += i;
        }
//        System.out.println(s);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
