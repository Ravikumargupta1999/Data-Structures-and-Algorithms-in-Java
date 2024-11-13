import java.util.ArrayList;
//https://practice.geeksforgeeks.org/problems/generate-binary-numbers-1587115620/1/?company[]=Amazon&company[]=Amazon&difficulty[]=-1&page=1&query=company[]Amazondifficulty[]-1page1company[]Amazon

public class Generate_Binary_Numbers {
    static ArrayList<String> generate(int n)
    {
        ArrayList<String> result = new ArrayList<>();
        if(n == 0)
            return new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            int temp = i;
            String str = "";
            while (temp > 0)
            {
                if(temp % 2 == 0)
                    str = '0' + str;
                else
                    str = '1' + str;
                temp = temp/2;
            }
            result.add(str);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generate(11));
    }
}
