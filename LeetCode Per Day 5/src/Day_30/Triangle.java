package Day_30;

import java.util.List;

public class Triangle {
    //             2
//             3  4
//             6  5  7
//             4  1  8  3

    // https://leetcode.com/problems/triangle/description/
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--) {

            for (int j = 0; j < triangle.get(i).size(); j++) {
                int v1 = triangle.get(i + 1).get(j);
                int v2 = triangle.get(i + 1).get(j + 1);
                int v3 = triangle.get(i).get(j);
                triangle.get(i).set(j,v3 + Math.min(v1,v2));
            }
        }
        return triangle.get(0).get(0);
    }


}
