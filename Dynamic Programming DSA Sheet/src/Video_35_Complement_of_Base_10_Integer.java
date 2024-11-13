public class Video_35_Complement_of_Base_10_Integer {
    public static int findComplement(int num) {
        String st = Integer.toBinaryString(num);
        char[] ch = st.toCharArray();

        for (int i = 0; i < ch.length; i++) {
            ch[i] = ch[i] == '0' ? '1' : '0';
        }

        st = new String(ch);

        return Integer.parseInt(st, 2);
    }

    // https://leetcode.com/problems/complement-of-base-10-integer/submissions/
    // https://leetcode.com/problems/number-complement/
    public int bitwiseComplement(int n) {
        int mask = 0;
        int m = n;
        if (n == 0)
            return 1;
        while (m != 0) {
            mask = (mask << 1) | 1;
            m = m >> 1;
        }
        return (~n) & mask;
    }


    public static void main(String[] args) {
        System.out.println(findComplement(10));
    }
}
