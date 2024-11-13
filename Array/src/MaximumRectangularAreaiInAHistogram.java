import java.util.Scanner;
import java.util.Stack;

public class MaximumRectangularAreaiInAHistogram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long[] arr = new long[(int) n];
        for (long i = 0; i < n; i++)
            arr[(int) i] = s.nextLong();
        System.out.println("");
        long value = getMaxArea(arr, n);
        System.out.println(value);
    }

    public static long getMaxArea(long[] arr, long n)
    {
        long[] rb = new long[(int)n];
        Stack<Long> st = new Stack<>();
        long longnum = n-1;
        st.push(longnum);
        rb[(int)longnum] =  arr.length;
        for(long i = arr.length-2;i>=0;i--)
        {
           long l = st.peek();
            while (st.size()>0 & arr[(int)i]<=arr[(int)l])
            {
                st.pop();
                if(st.size()>0)
                    l = st.peek();
            }
            if(st.size() == 0)
            {
                rb[(int)i] = arr.length;
            }
            else
                rb[(int)i] = st.peek();
            st.push(i);
        }
        long[] lb = new long[(int)n];
        st = new Stack<>();
        longnum = 0;
        st.push(longnum);
        lb[(int)longnum] =  -1;
        for(long i = 0;i<arr.length;i++)
        {
            long l = st.peek();
            while (st.size()>0 & arr[(int)i]<=arr[(int)l])
            {
                st.pop();
                if(st.size()>0)
                    l = st.peek();
            }
            if(st.size() == 0)
            {
                lb[(int)i] = -1;
            }
            else
                lb[(int)i] = st.peek();
            st.push(i);
        }


        long maxarea = Integer.MIN_VALUE;
        for(long i=0;i<arr.length;i++)
        {
            long width = rb[(int)i] - lb[(int)i];
            long area = arr[(int)i]*width;
            System.out.println(area+"    "+i+"     "+arr[(int) i]+"   "+width);
            if(area>maxarea)
                maxarea = area;
        }

        return maxarea;
    }
}
