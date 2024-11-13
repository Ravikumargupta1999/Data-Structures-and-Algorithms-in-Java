public class Numbers_Example {
   public static void print(int n)
   {
       if( n > 5)
           return;

       System.out.print(n+"  ");
       print(n+1);
       System.out.print(n+"  ");
   }
    public static void main(String[] args) {
        print(1);
    }
}
