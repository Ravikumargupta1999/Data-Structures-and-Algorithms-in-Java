import java.util.ArrayList;
import java.util.List;

//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays

public class Arrays_Left_Rotation {
    // Write your code here
    public static List<Integer> rotLeft(List<Integer> a, int d)
    {
        int n = a.size();
        d = d % n;
        reverse(a,0,d-1);
        reverse(a,d,n-1);
        reverse(a,0,n-1);
        return a;
    }
    public static void reverse(List<Integer> arr,int low,int high)
    {
        while (low <= high)
        {
            int temp = arr.get(low);
            arr.set(low, arr.get(high));
            arr.set(high, temp);
            low++;
            high--;
        }
    }

    public static void main(String[] args) {
        List<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(4);
        al.add(5);
        System.out.println(rotLeft(al,4));
    }

}
