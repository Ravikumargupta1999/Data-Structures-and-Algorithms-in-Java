package Language_Fundamental.Datatype;

public class Long_DataType {
    public static void main(String[] args) {
        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.MIN_VALUE);
        long val = Long.MAX_VALUE;
        int count = 0;
        while (val > 0)
        {
            val = val /10;
            count++;
        }
        System.out.println(count);
        long temp = (long) Math.pow(10,count) + val;
        System.out.println((Math.pow(10,count)));
        System.out.println(temp);
    }
}
