package Language_Fundamental.Datatype;

public class Integer_Datatype {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        int val = Integer.MAX_VALUE;
        int count = 0;
        while (val > 0)
        {
            val = val /10;
            count++;
        }
        System.out.println(count);
        int temp = (int) Math.pow(10,count) + val;
        System.out.println((Math.pow(10,count)));
        System.out.println(temp);
    }
}
