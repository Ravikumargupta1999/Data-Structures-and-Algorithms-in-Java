//https://practice.geeksforgeeks.org/problems/string-formation-from-substring2734/1/?category[]=Strings&category[]=Strings&company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=category[]Stringscompany[]Amazondifficulty[]1page1company[]Amazoncategory[]Strings#
//https://leetcode.com/problems/repeated-substring-pattern/
public class String_formation_from_substring {
    static int isRepeat(String s) {
        int len = s.length();
        for(int i= len/2;i>= 1;i--)
        {
            if(len % i == 0)
            {
                int repeat = len/i;
                String sub = s.substring(0,i);
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<repeat;j++)
                    sb.append(sub);
                if(sb.toString().equals(s))
                    return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(isRepeat("baba"));
    }
}
