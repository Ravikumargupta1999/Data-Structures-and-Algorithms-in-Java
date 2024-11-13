import java.awt.*;
import java.util.Arrays;

public class Reverse_String_Recursively {
    public static char[] reverse(char[] ch)
    {
        reverse1(ch,0,ch.length-1);
        return ch;
    }
    public static void reverse1(char[] ch,int start,int end)
    {
        if(start > end )
            return;
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
        reverse1(ch,start+1,end-1);
    }
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new char[]{'R','I','S','H','I','K','A'})));
    }
}
