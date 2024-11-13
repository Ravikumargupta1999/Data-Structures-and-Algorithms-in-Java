public class TCS {
    public static int Maximum(String str)
    {
        int len = 0;
        String temp = "";
        String[] arrOfStr = str.split(" ");
        System.out.println("");
        for(int i=0;i<arrOfStr.length;i++)
        {
            if (i != arrOfStr.length-1)
                System.out.print("( "+arrOfStr[i]+ " , "+arrOfStr[i].length()+" ) -->  ");
            else
                System.out.print("( "+arrOfStr[i]+ " , "+i+" ) . ");
        }
        System.out.println("");
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!= ' ')
            {
                temp += str.charAt(i);
            }
            else
            {
                int val = temp.length();
                temp = "";
                if(val > len)
                    len = val;
            }
        }
        return len;
    }
    public static void main(String[] args) {
        System.out.println(Maximum("111223##96%5566778899 Saturn V rockers first stage carries 203,400 gallons(700,000 liters) of kerosene fuel"));

    }
}
