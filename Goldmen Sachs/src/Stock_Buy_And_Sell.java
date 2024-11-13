import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

// https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/1/?company[]=Goldman%20Sachs&company[]=Goldman%20Sachs&page=3&query=company[]Goldman%20Sachspage3company[]Goldman%20Sachs#

public class Stock_Buy_And_Sell {
    public static void stockBuySell(int[] arr, int n) {
        ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
        if(n == 1)
            return;;
        if(n == 2)
        {
            if(arr[1]>arr[0])
            {
                ArrayList<Integer> al1 = new ArrayList<>();
                al1.add(0);
                al1.add(1);
                al.add(al1);

            }
            for(int i=0;i<al.size();i++)
            {
                System.out.print("("+al.get(i).get(0)+" "+al.get(i).get(1)+") ");
            }
            return;
        }
        int bd= 0;
        int sd = 0;
        int profit =0;

        for(int i=1;i<n;i++)
        {
            if(arr[i]>arr[i-1])
            {
                sd++;
            }
            else
            {
                ArrayList<Integer> al1 = new ArrayList<>();
                if(arr[bd]<arr[sd]) {
                    al1.add(bd);
                    al1.add(sd);
                    al.add(al1);
                }
                bd = sd = i;
            }

        }

        if(sd != bd) {
            ArrayList<Integer> al1 = new ArrayList<>();
            al1.add(bd);
            al1.add(sd);
            al.add(al1);
        }
        for(int i=0;i<al.size();i++)
        {
            System.out.print("("+al.get(i).get(0)+" "+al.get(i).get(1)+") ");
        }

       // return al;
//
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = 10;
        int[] arr= {23, 13, 25, 29, 33, 19, 34, 45, 65, 67};

        stockBuySell(arr,n);

    }
}
