//https://practice.geeksforgeeks.org/problems/remove-b-and-ac-from-a-given-string4336/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0page5company[]Amazon#

public class Remove_b_and_ac_from_given_String {
    public static String stringFilter(String str)
    {
        if(str.length() == 1)
            if(str.charAt(0) != 'b')
                return str;
            else
                return "";
        String temp = "";
        for(int i=0;i<str.length();i++)
        {
            System.out.println(i+"  "+(str.length()-1));
            if(str.charAt(i) == 'b') {
                temp = temp + str.charAt(i);
                continue;
            }
            else if(str.charAt(i) == 'a' && i != str.length()-1 && str.charAt(i+1) == 'c') {

                System.out.println(" jsdff");
                i+=1;
                continue;
            }
            else {
                temp = temp + str.charAt(i);
            }

        }
        return temp;
    }

    public static void main(String[] args) {
       // System.out.println(stringFilter("ad"));
       // System.out.println(stringFilter("acbac"));
       // System.out.println(stringFilter("aaac"));
       /// System.out.println(stringFilter("react"));
        System.out.println(stringFilter("aa"));
      //  System.out.println(stringFilter("ababaac"));

    }
}
//    ad
//
//            aa
//    ret
//            aa
//aaa