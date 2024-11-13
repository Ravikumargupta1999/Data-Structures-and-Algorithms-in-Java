public class Express_as_sum_of_power_of_natural_numbers {
    static int numOfWays(int n, int x)
    {
        return fun(n,x,1);
    }
    static int fun(int x,int power,int num)
    {
        int var = (int)Math.pow(num,power);
        if(var < x)
            return fun(x,power,num+1) + fun(x - var,power,num+1);
        else if( var == x)
            return 1;
        else
            return 0;
    }
}
