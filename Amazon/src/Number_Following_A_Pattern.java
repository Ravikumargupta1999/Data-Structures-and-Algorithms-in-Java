import java.util.Stack;
//https://practice.geeksforgeeks.org/problems/number-following-a-pattern3126/1/?category[]=Strings&category[]=Strings&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=2&query=category[]Stringscompany[]Amazondifficulty[]1page2company[]Amazoncategory[]Strings#

public class Number_Following_A_Pattern {
    static String printMinNumberForPattern(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        int num = 1;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == 'D')
            {
                st.push(num);
                num++;
            }
            else
            {
                st.push(num);
                num++;
                while (!st.isEmpty())
                    sb.append(st.pop());
            }
        }
        st.push(num);
        while (!st.isEmpty())
            sb.append(st.pop());
        return sb.toString();
        // code here
    }

    public static void main(String[] args) {
        System.out.println(printMinNumberForPattern("IIDDD"));
    }
}
