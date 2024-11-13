public class Searching_Sorting_103_Minimum_Of_Three_Number_In_Minimum_Comparison {
    // https://practice.geeksforgeeks.org/problems/middle-of-three2926/1
    int middle(int a, int b, int c) {
        if (a > b) {
            if (b > c)
                return b;
            else if (c > a)
                return a;
            else
                return c;
        } else {
            if (b < c) {
                return b;
            } else if (c < a) {
                return a;
            } else
                return c;
        }
    }
}
