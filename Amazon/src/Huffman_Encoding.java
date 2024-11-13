public class Huffman_Encoding {
    public static void main(String[] args) {
        String str2 = "0000 0001 00100 001010 001011 0011 0100 0101 0110 0111 1000 100100 100101 10011 1010 1011 1100 1101 11100 11101 111100 1111010 11110110 11110111 11111";
        String str1 = "0000 0001 00100 001010 001011 0011 0100 0101 0110 0111 1000 100100 100101 10011 1010 1011 1100 11010 11011 1110 111100 1111010 11110110 11110111 11111";
        String[] s1 = str1.split(" ");
        System.out.println(s1.length);
        String[] s2 = str2.split(" ");
        System.out.println(s2.length);
        int temp = -1;
        for(int i=0;i<s1.length;i++)
        {
            if(s1[i].compareTo(s2[i]) != 0)
            {
                System.out.println(s1[i]+"  "+s2[i]);
                temp = i;
                break;
            }
        }
        System.out.println(temp);
        System.out.println("Hello");
    }
}
