public class Any_Base_Subtraction {
    // https://practice.geeksforgeeks.org/problems/subtraction-and-two-numbers0816/1#
    static int subtraction(int n1, int n2, int b) {
        boolean sub = false;
        if( n1 > n2)
        {
            sub = true;
            int temp = n2;
            n2 = n1;
            n1 = temp;

        }
        System.out.println(n1+"  "+n2+"   "+b);
        int ans = 0;
        int p = 1;
        int c = 0;
        while (n2 > 0) {
            int d1 = n1 % 10;
            n1 = n1 / 10;

            int d2 = n2 % 10;
            n2 = n2 / 10;

            int d = 0;
            d2 = d2 + c;
            if (d2 >= d1) {
                c = 0;
                d = d2 - d1;
            } else {
                c = -1;
                d = d2 + b - d1;
            }
            ans = ans + (d * p);
            p = p * 10;
        }
        if(!sub)
            return (-1)*ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(subtraction(20,14,10));
    }
}
