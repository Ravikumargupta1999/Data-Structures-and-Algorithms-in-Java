import javax.print.DocFlavor;
import java.util.Stack;

public class Basic_Calculator_III {
    static class Pair {
        Stack<Integer> st;
        char sign;

        public Pair(Stack<Integer> st, char sign) {
            this.st = st;
            this.sign = sign;
        }
    }

    public static void cal(Stack<Integer> st, int val, char sign) {
        if (sign == '+') {
            st.push(val);
        } else if (sign == '-') {
            st.push(-val);
        } else if (sign == '*') {
            int a = st.pop();
            int ans = a * val;
            st.push(ans);
        } else if (sign == '/') {
            int a = st.pop();
            int ans = a / val;
            st.push(ans);
        }
    }

    public static int calculate(String s) {
        Stack<Pair> stP = new Stack<>();
        Stack<Integer> st = new Stack<>();
        int n = s.length();
        char sign = '+';
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    val = (val * 10) + (s.charAt(i) - '0');
                    i++;
                }
                i--;
                cal(st, val, sign);
            } else if (ch == '(') {
                stP.push(new Pair(st, sign));
                sign = '+';
                st = new Stack<>();
            } else if (ch == ')') {
                int val = 0;
                while (st.size() > 0) {
                    val += st.pop();
                }
                Pair p = stP.pop();
                st = p.st;
                sign = p.sign;
                cal(st, val, sign);
            } else if (ch != ' ') {
                sign = ch;
            }
        }
        int sum = 0;
        while (st.size() > 0)
            sum += st.pop();
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
    }
}
