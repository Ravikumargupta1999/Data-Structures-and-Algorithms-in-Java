public class Change_all_even_bits_in_a_number_to_0 {
    static long convertEvenBitToZero(long n) {
        String str = Long.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
            if (i % 2 == 0)
                sb.append('0');
            else
                sb.append(str.charAt(i));
        return Long.parseLong(sb.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(convertEvenBitToZero(10));
    }
}
