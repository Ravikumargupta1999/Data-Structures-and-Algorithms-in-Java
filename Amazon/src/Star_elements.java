import org.omg.Messaging.SYNC_WITH_TRANSPORT;

//https://practice.geeksforgeeks.org/problems/start-elements3447/1/?company[]=Amazon&company[]=Amazon&difficulty[]=0&page=12&query=company[]Amazondifficulty[]0page12company[]Amazon#

import java.util.ArrayList;

public class Star_elements {
    public static int[] getStarAndSuperStar(int[] arr, int n) {
        if( n == 1)
        {
            int[] a = new int[2];
            a[0] = arr[0];
            a[1] = arr[0];
            return a;
        }


        ArrayList<Integer> al = new ArrayList<>();
        int[] right = new int[n];
        right[n-1] = arr[n-1];
        al.add(arr[n-1]);

        int max = arr[n-1];

        for (int i=n-2;i>=0;i--)
        {
            if(arr[i] > max)
            {
                max = arr[i];
                right[i] = max;
                al.add(arr[i]);
            }
            right[i] = max;
        }
//        System.out.println(al);
        int i=0;
        int j = al.size()-1;
        while (i<= j)
        {
            //     System.out.println(al.get(i)+"  "+al.get(j));
            int temp = al.get(i);
            al.set(i,al.get(j));
            al.set(j,temp);
            i++;
            j--;
        }
//        System.out.println(al);
//        System.out.println("");

        int[] left = new int[n];
        left[0] = arr[0];
        max = arr[0];
        for (int l = 1;l< n;l++) {
            if (arr[l] > max) {
                max = arr[l];
                left[l] = max;
            }
            left[l] = max;
        }

        for(int l = 0;l<n;l++)
        {
            System.out.print(left[l]+"  ");
        }
        System.out.println("");
        for(int l = 0;l<n;l++)
        {
            System.out.print(right[l]+"  ");
        }
        System.out.println("");
        System.out.println(al);
        int t = 0;
        if(left[0] > right[1]) {
            // System.out.println("Hello Peter");
            al.add(t,arr[0]);
            t++;
        }
        if(right[n-1]> left[n-2])
        {
            // System.out.println("Hello Bsdk");
            al.add(arr[n-1]);
            t++;
        }
        for(int l = 1 ; l < n-1;l++)
        {
            if(arr[l] > left[l-1] && arr[l] > right[l+1])
            {
                // System.out.println("Hello Peter Bsdk");
                al.add(t,arr[l]);
                t++;
            }
        }
        if( t == 0)
            al.add(t,-1);

//        System.out.println(al);
        int[] res = new int[al.size()];
        for(int k=0; k < al.size();k++)
        {
            res[k] = al.get(k);
             System.out.print(res[k]+"  ");
        }
        return res;
    }

    public static void main(String[] args) {
        int arr[] = {88, 57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75};
        getStarAndSuperStar(arr,arr.length);
    }


}
