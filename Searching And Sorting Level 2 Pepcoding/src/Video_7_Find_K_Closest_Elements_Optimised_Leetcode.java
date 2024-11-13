import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Video_7_Find_K_Closest_Elements_Optimised_Leetcode {
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int s = 0;
        int e = arr.length-1;
        int mid = 0;
        while (s <= e)
        {
            mid = (s + e)/2;
            if(arr[mid] == x) {
                break;
            }
            else if(arr[mid] < x)
                s = mid + 1;
            else
                e = mid-1;
        }
        int l = mid-1;
        int r = mid ;

        // Important edge case
        if(mid == 0)
        {
            r = mid + 1;
            l = mid;
        }
        // System.out.println(arr[mid]);
        List<Integer> al = new ArrayList<>();
        while (  l >=0 && r < arr.length && k > 0)
        {
            if(Math.abs(arr[l] -x)<= Math.abs(arr[r]-x))
            {
                al.add(arr[l]);
                k--;
                l--;
            }
            else
            {
                al.add(arr[r]);
                k--;
                r++;
            }
        }
        while ( k > 0 && l >=0)
        {
            al.add(arr[l]);
            k--;
            l--;
        }
        while (k > 0 && r < arr.length)
        {
            al.add(arr[r]);
            k--;
            r++;
        }
        Collections.sort(al);
        return al;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 10};
        int k = 1, x = 4;
        System.out.println(findClosestElements(arr,k,x));
    }
}
