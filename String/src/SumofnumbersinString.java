import java.util.Scanner;

public class SumofnumbersinString {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        int value = SumString(str);
        System.out.println(value);
    }
    public static int SumString(String str)
    {
        char[] ch =str.toCharArray();
        int num = 0;
        int sum = 0;
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i] >= '0' &&  ch[i] <= '9')
            {
                num = num*10 + (ch[i]-'0');
            }
            else
            {
                sum+=num;
                num = 0;
            }

        }
        return sum+num;
    }
}
