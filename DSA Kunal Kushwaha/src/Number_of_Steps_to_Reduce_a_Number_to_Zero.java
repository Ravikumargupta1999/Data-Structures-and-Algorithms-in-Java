public class Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public int numberOfSteps(int num) {
        return totalSteps(num,0);
    }
    public static int totalSteps(int n,int steps)
    {
        if(n == 0)
            return steps;
//        System.out.println(n+"  "+steps);
        if (n % 2 == 0)
            return totalSteps(n/2,steps+1);
        else
            return totalSteps(n-1,steps+1);
    }

    public static void main(String[] args) {
        Number_of_Steps_to_Reduce_a_Number_to_Zero a = new Number_of_Steps_to_Reduce_a_Number_to_Zero();
        System.out.println(a.numberOfSteps(14));
    }
}
