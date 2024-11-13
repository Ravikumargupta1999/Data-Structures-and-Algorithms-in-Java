// https://practice.geeksforgeeks.org/problems/occurences-of-2-as-a-digit/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon

public class Occurences_of_2_as_a_digit {
    public static long count2s(long n) {
        String str = "";
        int count =0;
        for (int i = 2; i <= n; i++)
        {
            str = Integer.toString(i);
//            System.out.print(str+"  ");
            for (int j=0;j<str.length();j++)
            {
//                System.out.print(str.charAt(j)+"  ");
                if(str.charAt(j) == '2')
                    count++;
            }
//            System.out.println("");

        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(count2s(100));
    }
}
