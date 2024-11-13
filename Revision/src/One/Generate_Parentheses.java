package One;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/generate-parentheses/submissions/
// https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1/
public class Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        Parenthesis(n,0,0,"",list);
        return list;
    }
    public void Parenthesis(int n,int op,int cl,String str,List<String> list){
        Boolean f1 = false;
        if(op < n){
            f1 = true;
            Parenthesis(n,op+1,cl,str+"(",list);
        }
        if(cl < op){
            f1 = true;
            Parenthesis(n,op,cl+1,str+")",list);
        }
        if(!f1)
            list.add(str);

    }

    public static void main(String[] args) {
        System.out.println(new Generate_Parentheses().generateParenthesis(3));
    }
}
