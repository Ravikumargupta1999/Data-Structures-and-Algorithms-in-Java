package Sumit_Malik_Level_2;


// DOne

public class V_Video_1_Introduction_to_Bit_Manipulation {
    // https://practice.geeksforgeeks.org/problems/check-whether-k-th-bit-is-set-or-not-1587115620/1/?page=1&company[]=Amazon&company[]=Microsoft&company[]=Google&company[]=Flipkart&company[]=Adobe&company[]=Samsung&company[]=Accolite&company[]=MakeMyTrip&company[]=Zoho&company[]=Snapdeal&company[]=Goldman%20Sachs&company[]=Paytm&company[]=Walmart&company[]=Morgan%20Stanley&company[]=OYO%20Rooms&company[]=D-E-Shaw&company[]=Directi&company[]=MAQ%20Software&company[]=Cisco&company[]=Intuit%20&company[]=Codenation&category[]=Bit%20Magic&sortBy=submissions#
    static boolean checkKthBit(int n, int k) {
        int checkMask = (1 << (k));
        return (n & checkMask) == 0 ? false : true;
    }

    static boolean checkKthBit1(int n, int k) {
        int checkMask = (1 << (k));
        return (n & checkMask) > 0 ? true : false;
    }
    static int toggleBits(int N, int l, int r) {
        int size = (r - l + 1);
//        System.out.println(size);
        int val = (int) (Math.pow(2, size)) ;

//        int val = (1 <<size);


//        System.out.println(size+"   "+Integer.toBinaryString(val));

        val = val-1;
//        System.out.println(size+"   "+Integer.toBinaryString(val));
        val = val << (l - 1);
//        System.out.println(size+"   "+Integer.toBinaryString(val));


        return (N ^ val);
    }

    public static void main(String[] args) {
//        Scanner scn = new Scanner(System.in);
//        int n = scn.nextInt();
//        System.out.println("Binary representation of number : " + Integer.toBinaryString(n));
//        int i = scn.nextInt();
//        int j = scn.nextInt();
//        int k = scn.nextInt();
//        int m = scn.nextInt();
//
//        int onMask = (1 << i);
//        int offMask = ~(1 << j);
//        int toggleMask = (1 << k);
//        int checkMask = (1 << m);
//
//        System.out.println(n | onMask);
//        System.out.println(n & offMask);
//        System.out.println(n ^ toggleMask);
//        System.out.println((n & checkMask) == 0 ? "Bit was off" : " Bit was on");


    }


}
