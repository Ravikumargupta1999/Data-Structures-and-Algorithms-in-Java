import java.util.List;
// https://practice.geeksforgeeks.org/problems/find-the-highest-number2259/1/?company[]=Amazon&company[]=Amazon&page=2&query=company[]Amazonpage2company[]Amazon#

public class Peak_Number {
    public int findPeakElement(List<Integer> a)
    {
        int l =0;
        int r = a.size()-1;
        while (l<=r)
        {
            int mid = (l+r)/2;
            if(mid == a.size()-1)
                return a.get(mid);
            else if (mid == 0)
                return a.get(0);
            if(a.get(mid) > a.get(mid-1) && a.get(mid) <a.get(mid+1))
                return mid;
            else if(a.get(mid)>a.get(mid-1))
            {
                l = mid+1;
            }
            else
            {
                r = mid -1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {

    }
}
