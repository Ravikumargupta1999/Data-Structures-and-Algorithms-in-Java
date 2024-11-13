public class String_With_ASCII_difference_of_characters {
    public static void main(String[] args) {
        String str = "cbasaushddsfrgfhi";
        System.out.println(asciiDifference(str));
    }

    public static String asciiDifference(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        sb.append(" ");
        for (int i = 1; i < str.length(); i++) {
//            int val = str.charAt(i) - str.charAt(i - 1);
            sb.append(str.charAt(i) - str.charAt(i - 1));
            sb.append(" ");
            sb.append(str.charAt(i));
            sb.append(" ");
        }
        return sb.toString();
    }
}
