import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Pairs_With_Positive_Negative_Values {

    public long[] PosNegPair(long a[], long n) {
        ArrayList<long[]> list = new ArrayList<>();

        HashMap<Long, Long> map = new HashMap<>();
        for (long val : a) {
            if (map.containsKey(-val)) {
                if (val < 0)
                    list.add(new long[]{val, -val});
                else
                    list.add(new long[]{-val, val});
                if (map.get(-val) == 1)
                    map.remove(-val);
                else
                    map.put(-val, map.get(-val) - 1);
            }else {
                if(map.containsKey(val))
                    map.put(val, map.get(val) + 1);
                else
                    map.put(val,(long)1);
            }
        }
        Collections.sort(list,(l,m)->{
            return (int) (Math.abs(l[0])-Math.abs(m[0]));
        });
        long[] res = new long[2*list.size()];
        long j = 0;
        for (long i=0;i<list.size();i++){
            res[(int) j++] = list.get((int) i)[0];
            res[(int) j++] = list.get((int) i)[1];
        }
        return res;
    }
}
