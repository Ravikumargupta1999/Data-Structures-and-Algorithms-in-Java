package InterviewQuestion;

public class Video_46_Decode_It {
    static char decodeIt(String str, int k) {
        StringBuilder sb = new StringBuilder("");
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                int val = ch - '0';
                val--;
                StringBuilder newSb = new StringBuilder(sb);
                while (val-- > 0) {
                    sb.append(newSb);
                }
            } else
                sb.append(ch);

        }
        return sb.charAt(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(decodeIt("ser45", 4));
    }
}
