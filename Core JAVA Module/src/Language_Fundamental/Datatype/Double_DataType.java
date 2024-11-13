package Language_Fundamental.Datatype;

public class Double_DataType {
    public static void main(String[] args) {
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
        Double val = Double.MAX_VALUE;
        int count = 0;
        System.out.println("\n\n\n");
        while (val > 0)
        {
            val = val /10;
            System.out.println(count);
            count++;
        }
        System.out.println(count);
        System.out.println("\n\n\n");
        Double temp = (Double) Math.pow(10,count) + val;
        System.out.println((Math.pow(10,count)));
        System.out.println(temp);
    }
}
