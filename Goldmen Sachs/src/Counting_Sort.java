public class Counting_Sort {
    public static String countSort(String arr)
    {

        char[] ch = new char[26];
        for(int i=0;i<arr.length();i++)
            ch[(int)arr.charAt(i)-97]++;
        String str = "";
        for(int i=0;i<ch.length;i++) {
            int size = ch[i];
            for (int j = 0; j < size; j++)
                str = str + (char) (97 + i);
        }
        return str;

    }

    public static void main(String[] args) {
        System.out.println(countSort("geeksforgeeks"));
        System.out.println();
        System.out.println((int)'a'-97);
        char ch = 97 + 0;
        System.out.println(ch);
    }
}
