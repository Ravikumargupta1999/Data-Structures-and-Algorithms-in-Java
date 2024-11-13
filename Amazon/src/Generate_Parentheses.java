//Initial Template for Java

import java.io.*;
import java.util.*;
// https://leetcode.com/problems/generate-parentheses/submissions/
//https://practice.geeksforgeeks.org/problems/generate-all-possible-parentheses/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon#

class GFG1{

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution1 T = new Solution1();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            System.out.println(ans.size());
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }

            t--;

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution1 {

    public List<String> AllParenthesis(int n)
    {
        if( n== 0)
            return new ArrayList<>();
        if( n == 1)
        {
            List<String> al = new ArrayList<>();
            al.add("()");
            return al;
        }
        List<String> al = new ArrayList<>();
        solve(n,n,"",al);
        return al;
    }
    static void solve(int open,int close,String str,List<String> al)
    {
        // System.out.println(open+" " +close);
        if(open == 0 && close == 0)
        {
            // System.out.println(open+" first if " +close);
            al.add(str);
//            System.out.println(al);
            return;
        }
        if(open != 0)
        {
            // System.out.println(open+"  second if " +close);
            solve(open-1,close,str + "(",al);
        }
        if (open < close)
        {
            // System.out.println(open+" third if " +close);
            solve(open,close-1,str + ")",al);
        }
        return;
    }
}