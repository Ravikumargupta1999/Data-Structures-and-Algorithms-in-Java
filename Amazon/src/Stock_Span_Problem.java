import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Arrays;
import java.util.Stack;

public class Stock_Span_Problem {
    //Function to calculate the span of stockâ€™s price for all n days.
    static class Pair
    {
        int index;
        int value;

    }
    public static int[] calculateSpan(int arr[], int n)
    {
        int[] ans = new int[n];
        ans[0] = 1;
        Stack<Pair> stack = new Stack<>();
        Pair max = new Pair();
        max.index = 0;
        max.value = arr[0];
        stack.push(max);
        for(int i = 1; i<n;i++)
        {
            while (!stack.isEmpty() && stack.peek().value < arr[i])
                stack.pop();
            if(stack.size() == 0)
            {
                ans[i] = i+1;
            }
            else
            {
                ans[i] = (i - stack.peek().index );
            }
            Pair temp = new Pair();
            temp.index = i;
            temp.value = arr[i];
            stack.push(temp);
        }
//        for(int i=0;i<n;i++)
//            System.out.print(ans[i] +"  ");
//        System.out.println("");
        return ans;

    }

    public static void main(String[] args) {
        int N = 6, price[] = {100, 80, 60, 70, 60, 75,85};
        calculateSpan(price,price.length);
        String str1 = "1 2 3 1 1 2 7 1 2 10 1 2 3 1 2 16 1 2 1 1 2 3 1 1 1 4 1 10 13 1 2 1 4 18 1 1 3 4 1 24 1 2 1 2 3 6 1 2 3 1 11 12 1 2 3 4 1 6 1 1 2 3 4 6 1 66 1 2 1 2 1 1 2 1 1 5 11 1 1 1 4 5 1 1 1 2 3 4 1 1 7 1 11 1 1 1 2 3 5 23 1 1 2 1 4 1 1 2 8 1 10 1 1 14 1 1 17 18 1 2 3 1 2 1 4 1 6 1 2 3 1 1 2 134";
        String str2 = "1 2 3 1 1 2 7 1 2 10 1 2 3 1 2 16 1 2 1 1 2 3 1 1 1 4 1 10 13 1 2 1 4 18 1 1 3 4 1 24 1 2 1 2 3 6 1 2 3 1 11 12 1 2 3 4 1 6 1 1 2 3 4 6 1 66 1 2 1 2 1 1 2 1 1 5 77 1 1 1 4 5 1 1 1 2 3 4 1 1 7 1 11 1 1 1 2 3 5 23 1 1 2 1 4 1 1 2 8 1 10 1 1 14 1 1 17 18 1 2 3 1 2 1 4 1 6 1 2 3 1 1 2 134";
        System.out.println(str1.compareTo(str2));
        for (int i=0;i<str1.length();i++)
        {
            if (str1.charAt(i) != str2.charAt(i)) {
                System.out.println(i+"  "+str1.charAt(i)+"  "+str2.charAt(i));
                break;
            }
            System.out.println(str1.charAt(i)+"  "+str2.charAt(i));
        }
    }
}
