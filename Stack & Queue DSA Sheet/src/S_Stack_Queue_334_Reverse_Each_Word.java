import java.util.ArrayList;
import java.util.Stack;
// https://practice.geeksforgeeks.org/problems/reverse-each-word-in-a-given-string1001/1/?category[]=Stack&category[]=Stack&page=2&query=category[]Stackpage2category[]Stack
// try using stack also
public class S_Stack_Queue_334_Reverse_Each_Word {
    static String reverseWords(String s)
    {
        ArrayList<String> al = new ArrayList<>();

        String s1 = "";
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == '.')
            {
                al.add(s1);
                s1 = "";
            }
            else
            {
                s1 = s1 + s.charAt(i);
            }
        }
        al.add(s1);
        String result  = "";
        for(int i=0;i<al.size();i++)
        {
            if(i == 0)
                result = result +reverse(al.get(i));
            else
                result = result + "." +reverse(al.get(i));
        }
        return result;
    }
    public static String reverse(String S){
        Stack<Character> st = new Stack<>();
        int n = S.length();
        for(int i=0;i<S.length();i++)
        {
            char c = S.charAt(i);
            st.push(c);
        }

        S = "";
        for(int i=0;i<n;i++)
        {
            S = S+st.peek();

            st.pop();
        }
        return S;

    }

    public static void main(String[] args) {
        System.out.println(reverseWords("i.like.this.program.very.much"));
    }


}
