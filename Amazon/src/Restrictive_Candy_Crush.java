import java.util.Stack;
// https://practice.geeksforgeeks.org/problems/8c8f95810b05b4cab665f2997d36991bd58308a2/1/
public class Restrictive_Candy_Crush {
    static class Pair {
        int count;
        char ch;

        public Pair(char c, int count) {
            this.ch = c;
            this.count = count;

        }
    }

    public static String reduced_String(int k, String s) {
        if (k == 1)
            return "";
        Stack<Pair> st = new Stack<>();
        int count = 0;

        StringBuilder sb = new StringBuilder();
        for(char i : s.toCharArray())
        {

            if(st.isEmpty())
            {
                count = 1;
                st.push(new Pair(i,count));
            }
            else
            {
                if(st.peek().ch == i)
                {
                    count = st.peek().count+1;
                    st.push(new Pair(st.peek().ch,count));
                    if(count == k)
                    {
                        while (count-- > 0) {
                            System.out.println("Hello 1");
                            st.pop();
                        }
                    }
                }
                else
                {
                    count = 1;
                    st.push(new Pair(i,count));
                }
            }
            if(!st.isEmpty())
            System.out.println(st.peek().ch+"   "+st.peek().count);
        }
        while (!st.isEmpty()) {
            sb.append(st.peek().ch);
            st.pop();
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(reduced_String(2, "geeksforgeeks"));
    }
}
