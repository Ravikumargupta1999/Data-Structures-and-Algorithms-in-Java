import java.util.List;
import java.util.Stack;
//https://www.hackerrank.com/challenges/largest-rectangle/problem?h_r=internal-search

public class Largest_Rectangle {
    public static long largestRectangle(List<Integer> arr) {
        Stack<Integer> s = new Stack<>();
        int n = arr.size();

        long max_area = 0;
        long tp;
        long area_with_top;
        int i = 0;
        while (i < n) {
            if (s.empty() || arr.get(s.peek()) <= arr.get(i))
                s.push((int) i++);
            else {
                tp = s.peek();
                s.pop();
                area_with_top = arr.get((int) tp) * (s.empty() ? i : i - s.peek() - 1);
                if (max_area < area_with_top)
                    max_area = area_with_top;
            }
        }
        while (s.empty() == false) {
            tp = s.peek();
            s.pop();
            area_with_top = arr.get((int) tp) * (s.empty() ? i : i - s.peek() - 1);

            if (max_area < area_with_top)
                max_area = area_with_top;
        }
        return max_area;


    }
}
