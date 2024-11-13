import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
// https://practice.geeksforgeeks.org/problems/unique-numbers3019/1/?company[]=Amazon&company[]=Amazon&page=3&query=company[]Amazonpage3company[]Amazon#

public class Unique_Numbers {
    static ArrayList<Integer> uniqueNumbers(int L, int R){
      ArrayList<Integer> al = new ArrayList<>();
      for(int l = L;l<=R;l++)
      {
          if(l>=1 && l <=9)
              al.add(l);
          String str = Integer.toString(l);
          if(check(str) == true)
              al.add(l);
      }
      return al;
    }
    static boolean check(String str)
    {
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++)
           if(set.contains(str.charAt(i)))
               return false;
           else
               set.add(str.charAt(i));
        return true;
    }


    static ArrayList<Integer> uniqueNumbers1(int l,int r){
        ArrayList<Integer> al = new ArrayList<>();
        for (int i=l ; i<=r ; i++)
        {
            int num = i;
            boolean visited[] = new boolean[10];
            while (num != 0)
            {
                if (visited[num % 10])
                    break;

                visited[num%10] = true;

                num = num/10;
            }

            if (num == 0)
                al.add(i);
        }
        return al;
    }
}
