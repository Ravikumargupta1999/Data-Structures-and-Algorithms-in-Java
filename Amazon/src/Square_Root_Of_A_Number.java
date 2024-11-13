//https://practice.geeksforgeeks.org/problems/square-root/1/?company[]=Amazon&company[]=Amazon&difficulty[]=1&page=1&query=company[]Amazondifficulty[]1page1company[]Amazon

public class Square_Root_Of_A_Number {
    static long floorSqrt(long x)
    {
        long start = 1;
        long end = x;
        while (start<= end)
        {
            long mid = start + (end-start)/2;
            if(mid* mid > x)
                end = mid -1;
            else if(mid*mid < x)
                start = mid +1;
            else if(mid*mid == x)
                return mid;
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(floorSqrt(8));
    }
}
