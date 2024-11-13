import java.util.ArrayList;
import java.util.List;

public class Leetcode_241_Different_Ways_To_Add_Parentheses {
    // https://leetcode.com/problems/different-ways-to-add-parentheses/submissions/
    public static void main(String[] args) {
        String expression = "2*3-4*5";
        System.out.println(new Leetcode_241_Different_Ways_To_Add_Parentheses().diffWaysToCompute(expression));
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                for (int a : left) {
                    for (int b : right) {
                        if (ch == '+') {
                            list.add(a + b);
                        } else if (ch == '-') {
                            list.add(a - b);
                        } else if (ch == '*') {
                            list.add(a * b);
                        }
                    }
                }
            }
        }
        if(list.size() == 0){
            list.add(Integer.parseInt(expression));
        }
        return list;
    }
}
