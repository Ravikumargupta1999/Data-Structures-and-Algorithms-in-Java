//https://practice.geeksforgeeks.org/problems/count-substrings0427/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=5&query=company[]Amazondifficulty[]0company[]Amazonpage5

public class Count_Substrings {
    // Approach : 1
    static int countSubstring(String s)
    {
        int count = 0;
        for(int i=0;i<s.length()-1;i++)
            if(s.charAt(i) == '1')
                for (int j= i+1;j<s.length();j++)
                    if(s.charAt(j) == '1')
                        count++;
        return count;
    }

    // Approach : 2
    static int countSubString1(String s)
    {
        int count = 0;
        for(int i=0;i<s.length();i++)
            if(s.charAt(i) == '1')
                count++;
        return count*(count-1)/2;
    }
    public static void main(String[] args) {
        System.out.println(countSubString1("10101"));
    }
}
