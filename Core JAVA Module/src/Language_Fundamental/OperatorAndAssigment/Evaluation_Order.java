package Language_Fundamental.OperatorAndAssigment;

public class Evaluation_Order {
    public static void main(String[] args) {
        System.out.println(m1(1)+m1(2)*m1(3)/m1(4)+m1(5)*m1(6));
        System.out.println("\n\n");
        System.out.println(m1(1)+m1(2)/m1(3)*m1(4)+m1(5)*m1(6));
    }
    public static int m1(int i)
    {
        System.out.println(i);
        return i;
    }
}
