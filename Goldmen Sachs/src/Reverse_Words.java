import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Reverse_Words {
    static String reverseWords(String s)
    {
        Queue<Character> queue = new LinkedList<>();
        for(int i=0;i<s.length();i++)
        {
            queue.add(s.charAt(i));
        }
        ArrayList<String> al = new ArrayList<>();
        String str = "";
        while (!queue.isEmpty())
        {
            if(queue.peek() == '.'){
                al.add(str);
                str = "";
                queue.poll();
            }
            else
            {
                str = str + queue.poll();
            }
        }
        al.add(str);
        str = "";
        str = str + al.get(al.size()-1);
        for(int i= al.size()-2;i>=0;i--)
            str = str +"."+al.get(i) ;
        System.out.println(al);

        System.out.println("Using Method 1 : "+str);
        System.out.print("Using Method 2 : ");
        String S = s;
        String result = "";
        int last = S.length();
        for(int i = S.length()-1;i >=0;i--)
        {
            if(S.charAt(i) == '.')
            {
                if(result.length() == 0)
                {
                    result = result + S.substring(i+1,last);
                    last = i;
                }
                else
                {
                    result = result +'.'+ S.substring(i+1,last);
                    last = i;
                }

            }
        }

        if(result.length() == 0)
            return S;
        result = result +'.'+ S.substring(0,last);
        return result;

    }
    public static void main(String[] args) {
        System.out.println(reverseWords("hs.a"));
    }
}
