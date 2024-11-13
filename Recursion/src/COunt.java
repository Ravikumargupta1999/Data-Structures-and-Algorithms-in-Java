public class COunt {

    public static void print(int n)
    {
        if(n == 0)
            return ;
        print(n-1);
        System.out.println(n);

    }
    public static void main(String[] args) {
       print(5);
    }
}
// Input : 5 /n
// Output : 1,2,3,4,5 or 5,4,3,4,2
