import java.lang.reflect.Array;
import java.util.ArrayList;

public class Subset_With_Product_Less_Than_K {
//    int findSubset(int arr[], int n,int k)
//    {
//
//       ArrayList<Integer> vect1, vect2, subset1, subset2;
//        for (int i = 0; i < n; i++) {
//            if (arr[i] > k)
//                continue;
//            if (i <= n / 2)
//                vect1.add(arr[i]);
//            else
//                vect2.add(arr[i]);
//        }
//
//        for (int i = 0; i < (1 << vect1.size()); i++) {
//            int value = 1;
//            for (int j = 0; j < vect1.size(); j++) {
//             //   if (i & (1 << j))
//                    value *= vect1.get(j);
//            }
//
//            // push only in case subset product is less
//            // than equal to k
//            if (value <= k)
//                subset1.add(value);
//        }
//        for (int i = 0; i < (1 << vect2.size()); i++) {
//            int value = 1;
//            for (int j = 0; j < vect2.size(); j++) {
//               // if ((i) & (1 << j) == )
//                    value *= vect2.get(j);
//            }
//
//            // push only in case subset product is
//            // less than equal to k
//            if (value <= k)
//                subset2.add(value);
//        }
//
//        // sort subset2
//        sort(subset2.begin(), subset2.end());
//
//        int count = 0;
//        for (int i = 0; i < subset1.size(); i++)
//            count += upper_bound(subset2.begin(), subset2.end(),
//                    (k / subset1[i]))
//                    - subset2.begin();
//
//        count--;
//
//        return count;
//    }
    public static void main(String[] args) {

    }
}
