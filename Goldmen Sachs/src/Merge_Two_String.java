// https://practice.geeksforgeeks.org/problems/merge-two-strings2736/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=4&query=company[]Goldman%20Sachspage4company[]Goldman%20Sachs

public class Merge_Two_String {

    static String merge(String s1, String s2)
    {
        String str = "";
        int l1 = s1.length();
        int l2 = s2.length();
        if(l1 > l2)
        {
            for(int i =0;i<l1;i++)
            {
                if(i>l2-1)
                {
                    str = str + s1.charAt(i);
                }
                else
                {
                    str = str + s1.charAt(i) + s2.charAt(i);
                }
                System.out.println("i :"+str);
            }
        }
        else
        {
            for(int i =0;i<l2;i++)
            {
                if(i>l1-1)
                {
                    str = str + s2.charAt(i);
                }
                else
                {
                    str = str + s1.charAt(i) + s2.charAt(i);
                }
                //System.out.println("i :"+str);
            }
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(merge("Pr","Ravi"));

    }
}
