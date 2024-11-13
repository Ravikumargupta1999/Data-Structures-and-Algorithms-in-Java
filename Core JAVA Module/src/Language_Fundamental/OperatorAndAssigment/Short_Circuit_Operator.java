package Language_Fundamental.OperatorAndAssigment;

public class Short_Circuit_Operator {
    public static void main(String[] args) {
        int x = 10;
        int y = 15;
        System.out.println(x+"   "+y);
        if(++x < 10 && ++y>15)
            x++;
        else
            y++;
        System.out.println(x+"  "+y);

    }
}
